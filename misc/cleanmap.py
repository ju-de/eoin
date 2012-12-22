#!/usr/bin/env python
# -*- coding: utf-8 -*-
# UNTITLED GAME map cleaner utility
# Copyright Filip Burlacu 2012
# Licensed under GNU GPLv3.0

import sys # needed for command-line
from random import randint

# basic file io
def readFile(name):
    with open(name, "r") as fin:
        for line in fin:
            yield [i for i in line]

def writeLine(name, line):
    with open(name, "a") as fout:
        fout.write(str(line) + "\n")


SOLID_ABOVE = "zXxcAaDd-=,.bnmBNMvFf"
SOLID_BELOW = "qWweAaDd-=,.bnmGHJRrFf"
SOLID_LEFT  = "WweDdcXx-=,.hjHJnmNMYyu"
SOLID_RIGHT = "WwqAazXx-=,.ghGHnmNMtYy"

SOLID_NONLADDERS = "-=,.qweasdzxcWADXrfvRF" # you can jsut use -=,. for cleaner cleanup
SOLID_LADDERS = "ghjGHJbnmBNMk"

"""
This matrix controls the choices of the blocks
-- using each subscrpit as a choice

The first subscript is for blocks above,
second for blocks left,
third for blocks below,
fourth for blocks right.

"""
CHOICE_MATRIX = [
        [  # no block above
            [ #no block left
                [ # no block below
                    "s" # no block right
                     ,
                    "t" # block right
                ],
                [ # block below
                    "r" # no block right
                     ,
                    "q" # block right
                ],
            [ # block left
                [ # no block below
                    "u" # no block right
                     ,
                    "y" # block right
                ],
                [ # block below
                    "e" # no block right
                     ,
                    "w" # block right
                ]
            ]
        ], [  # block above
            [ #no block left
                [ # no block below
                    "v" # no block right
                     ,
                    "z" # block right
                ],
                [ # block below
                    "f" # no block right
                     ,
                    "a" # block right
                    ]
                ],
            [ # block left
                [ # no block below
                    "c" # no block right
                     ,
                    "x" # block right
                ],
                [ # block below
                    "d" # no block right
                     ,
                    "-" # block right
                ]
            ]
        ]
    ]
]



"""
Same as above, but for ladders.

IMPORTANT -- what are the column ladder blocks?
as it appears there are none, but on the spritesheets it looks otherwise///
"""
CHOICE_MATRIX_LADDER = [[[["k","g"],["H","G"]],[["j", "h" ],["J","H" ]]], [  [["N", "B" ],["n", "b"],[ [ "M","N"],[ "m","n" ]]]]]



"""
Walks through the entire map, setting boundary dirt as necessary
That is, if it finds a piece of dirt with open space to the right,
it sets it as a D (rnadomizeBlocks shound be used afterwards)
"""
def boundaryDirt(maparr):
    for y in xrange(len(maparr)):
        for x in xrange(len(maparr[y])):
            print y
            top = "." if y == 0  else ("." if len(maparr[y-1]) <= x else maparr[y-1][x])
            right = "." if x == len(maparr[y]) - 1 else maparr[y][x+1]
            left = "." if x == 0 else maparr[y][x-1]
            bot = "." if y == len(maparr)-1 else ( "." if len(maparr[y+1]) <= x else maparr[y+1][x])
            # now for conditions, using above condition matrix
            if maparr[y][x] in SOLID_NONLADDERS:
                print x, y
                # currently bugs out
                maparr[y][x] = CHOICE_MATRIX[top in SOLID_BELOW][left in SOLID_RIGHT][bot in SOLID_ABOVE][right in SOLID_LEFT]
            elif maparr[y][x] in SOLID_LADDERS:
                maparr[y][x] = CHOICE_MATRIX_LADDER[top in SOLID_BELOW][left in SOLID_RIGHT][bot in SOLID_ABOVE][right in SOLID_LEFT]
            
        
    pass

            

# in-place modification
def randomizeDirt(line):
    for i in xrange(len(line)):
        shuffle(line, i, "-=,.")
        shuffle(line,i, "aA")
        shuffle(line,i, "Ww")
        shuffle(line,i, "Dd")
        shuffle(line,i, "Xx")
        shuffle(line,i, "Ff")
        
        
    return

def shuffle(ar, i, string):
    if ar[i] in string:
        ar[i] = string[randint(0, len(string) - 1)]

def printHelp():
    print """ -- HELP --
NAME
    cleanmap.py - a utility written in python for cleaning map files for
    UNTITLED GAME
SYNOPSIS
    python cleanmap.py [-?] [-s source] [-d destination] [-c command]
DESCRIPTION
    The MapCleaner utility automates some simple tasks used to clean maps.
COMMAND LINE OPTIONS
    -?, -h, --help
        Prints this help documentation and exits.
    -c, --clean
        Does something or other BETTER DOCUMENTATION NEEDED
"""
    ##
""##

#the actual run
print " -- UNTITLED GAME MapCleaner Utility --"
print "© Filip Burlacu 2012 licensed under GNU GPLv3.0"
#print sys.argv
if len(sys.argv) == 1:
    print "Run MapCleaner with command --help or -h for help"
else:
    if sys.argv[1] in ("-h", "--help", "-?"):
        printHelp()
    else:
        if sys.arv[1] in ("-c", "--clean"):
            if len(sys.argv) < 4:
                print "required usage: python cleanmap.py -c input_file.txt output_file.txt"
                print "input and output files should be different"
            else:
                inFile, outFile = sys.argv[2], sys.argv[3]
                the_map = []
                for line in readFile(inFile):
                    the_map.append([i for i in line])
                boundaryDirt(the_map)
                for row in the_map:
                    randomizeDirt(row)
                    writeLine(outFile, "".join(row))
                
                
                





