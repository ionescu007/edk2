## @file
# This file is used to define each component of Target.txt file
#
# Copyright (c) 2007 - 2014, Intel Corporation. All rights reserved.<BR>
# This program and the accompanying materials
# are licensed and made available under the terms and conditions of the BSD License
# which accompanies this distribution.  The full text of the license may be found at
# http://opensource.org/licenses/bsd-license.php
#
# THE PROGRAM IS DISTRIBUTED UNDER THE BSD LICENSE ON AN "AS IS" BASIS,
# WITHOUT WARRANTIES OR REPRESENTATIONS OF ANY KIND, EITHER EXPRESS OR IMPLIED.
#

##
# Import Modules
#
import Common.LongFilePathOs as os
import EdkLogger
import DataType
from BuildToolError import *
import GlobalData
from Common.LongFilePathSupport import OpenLongFilePath as open

gDefaultTargetTxtFile = "target.txt"

## TargetTxtClassObject
#
# This class defined content used in file target.txt
#
# @param object:             Inherited from object class
# @param Filename:           Input value for full path of target.txt
#
# @var TargetTxtDictionary:  To store keys and values defined in target.txt
#
class TargetTxtClassObject(object):
    def __init__(self, Filename = None):
        self.TargetTxtDictionary = {
            DataType.TAB_TAT_DEFINES_ACTIVE_PLATFORM                            : '',
            DataType.TAB_TAT_DEFINES_ACTIVE_MODULE                              : '',
            DataType.TAB_TAT_DEFINES_TOOL_CHAIN_CONF                            : '',
            DataType.TAB_TAT_DEFINES_MAX_CONCURRENT_THREAD_NUMBER               : '',
            DataType.TAB_TAT_DEFINES_TARGET                                     : [],
            DataType.TAB_TAT_DEFINES_TOOL_CHAIN_TAG                             : [],
            DataType.TAB_TAT_DEFINES_TARGET_ARCH                                : [],
            DataType.TAB_TAT_DEFINES_BUILD_RULE_CONF                            : '',
        }
        self.ConfDirectoryPath = ""
        if Filename is not None:
            self.LoadTargetTxtFile(Filename)

    ## LoadTargetTxtFile
    #
    # Load target.txt file and parse it, return a set structure to store keys and values
    #
    # @param Filename:  Input value for full path of target.txt
    #
    # @retval set() A set structure to store keys and values
    # @retval 1     Error happenes in parsing
    #
    def LoadTargetTxtFile(self, Filename):
        if os.path.exists(Filename) and os.path.isfile(Filename):
             return self.ConvertTextFileToDict(Filename, '#', '=')
        else:
            EdkLogger.error("Target.txt Parser", FILE_NOT_FOUND, ExtraData=Filename)
            return 1

    ## ConvertTextFileToDict
    #
    # Convert a text file to a dictionary of (name:value) pairs.
    # The data is saved to self.TargetTxtDictionary
    #
    # @param FileName:             Text filename
    # @param CommentCharacter:     Comment char, be used to ignore comment content
    # @param KeySplitCharacter:    Key split char, between key name and key value. Key1 = Value1, '=' is the key split char
    #
    # @retval 0 Convert successfully
    # @retval 1 Open file failed
    #
    def ConvertTextFileToDict(self, FileName, CommentCharacter, KeySplitCharacter):
        F = None
        try:
            F = open(FileName, 'r')
            self.ConfDirectoryPath = os.path.dirname(FileName)
        except:
            EdkLogger.error("build", FILE_OPEN_FAILURE, ExtraData=FileName)
            if F is not None:
                F.close()

        for Line in F:
            Line = Line.strip()
            if Line.startswith(CommentCharacter) or Line == '':
                continue

            LineList = Line.split(KeySplitCharacter, 1)
            Key = LineList[0].strip()
            if len(LineList) == 2:
                Value = LineList[1].strip()
            else:
                Value = ""

            if Key in [DataType.TAB_TAT_DEFINES_ACTIVE_PLATFORM, DataType.TAB_TAT_DEFINES_TOOL_CHAIN_CONF, \
                       DataType.TAB_TAT_DEFINES_ACTIVE_MODULE, DataType.TAB_TAT_DEFINES_BUILD_RULE_CONF]:
                self.TargetTxtDictionary[Key] = Value.replace('\\', '/')
                if Key == DataType.TAB_TAT_DEFINES_TOOL_CHAIN_CONF and self.TargetTxtDictionary[Key]:
                    if self.TargetTxtDictionary[Key].startswith("Conf/"):
                        Tools_Def = os.path.join(self.ConfDirectoryPath, self.TargetTxtDictionary[Key].strip())
                        if not os.path.exists(Tools_Def) or not os.path.isfile(Tools_Def):
                            # If Conf/Conf does not exist, try just the Conf/ directory
                            Tools_Def = os.path.join(self.ConfDirectoryPath, self.TargetTxtDictionary[Key].replace("Conf/", "", 1).strip())
                    else:
                        # The File pointed to by TOOL_CHAIN_CONF is not in a Conf/ directory
                        Tools_Def = os.path.join(self.ConfDirectoryPath, self.TargetTxtDictionary[Key].strip())
                    self.TargetTxtDictionary[Key] = Tools_Def
                if Key == DataType.TAB_TAT_DEFINES_BUILD_RULE_CONF and self.TargetTxtDictionary[Key]:
                    if self.TargetTxtDictionary[Key].startswith("Conf/"):
                        Build_Rule = os.path.join(self.ConfDirectoryPath, self.TargetTxtDictionary[Key].strip())
                        if not os.path.exists(Build_Rule) or not os.path.isfile(Build_Rule):
                            # If Conf/Conf does not exist, try just the Conf/ directory
                            Build_Rule = os.path.join(self.ConfDirectoryPath, self.TargetTxtDictionary[Key].replace("Conf/", "", 1).strip())
                    else:
                        # The File pointed to by BUILD_RULE_CONF is not in a Conf/ directory
                        Build_Rule = os.path.join(self.ConfDirectoryPath, self.TargetTxtDictionary[Key].strip())
                    self.TargetTxtDictionary[Key] = Build_Rule
            elif Key in [DataType.TAB_TAT_DEFINES_TARGET, DataType.TAB_TAT_DEFINES_TARGET_ARCH, \
                         DataType.TAB_TAT_DEFINES_TOOL_CHAIN_TAG]:
                self.TargetTxtDictionary[Key] = Value.split()
            elif Key == DataType.TAB_TAT_DEFINES_MAX_CONCURRENT_THREAD_NUMBER:
                try:
                    V = int(Value, 0)
                except:
                    EdkLogger.error("build", FORMAT_INVALID, "Invalid number of [%s]: %s." % (Key, Value),
                                    File=FileName)
                self.TargetTxtDictionary[Key] = Value
            #elif Key not in GlobalData.gGlobalDefines:
            #    GlobalData.gGlobalDefines[Key] = Value

        F.close()
        return 0

    ## Print the dictionary
    #
    # Print all items of dictionary one by one
    #
    # @param Dict:  The dictionary to be printed
    #
    def printDict(Dict):
        if Dict is not None:
            KeyList = Dict.keys()
            for Key in KeyList:
                if Dict[Key] != '':
                    print Key + ' = ' + str(Dict[Key])

    ## Print the dictionary
    #
    # Print the items of dictionary which matched with input key
    #
    # @param list:  The dictionary to be printed
    # @param key:   The key of the item to be printed
    #
    def printList(Key, List):
        if type(List) == type([]):
            if len(List) > 0:
                if Key.find(TAB_SPLIT) != -1:
                    print "\n" + Key
                    for Item in List:
                        print Item
## TargetTxtDict
#
# Load target.txt in input Conf dir
#
# @param ConfDir:  Conf dir
#
# @retval Target An instance of TargetTxtClassObject() with loaded target.txt
#
def TargetTxtDict(ConfDir):
    Target = TargetTxtClassObject()
    Target.LoadTargetTxtFile(os.path.normpath(os.path.join(ConfDir, gDefaultTargetTxtFile)))
    return Target

##
#
# This acts like the main() function for the script, unless it is 'import'ed into another
# script.
#
if __name__ == '__main__':
    pass
    Target = TargetTxtDict(os.getenv("WORKSPACE"))
    print Target.TargetTxtDictionary[DataType.TAB_TAT_DEFINES_MAX_CONCURRENT_THREAD_NUMBER]
    print Target.TargetTxtDictionary[DataType.TAB_TAT_DEFINES_TARGET]
    print Target.TargetTxtDictionary
