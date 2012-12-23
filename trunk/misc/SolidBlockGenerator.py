import random

#Generates a solid map of random , . - = blocks, useful for any sort of cavernous level
#allowing you to simply "carve" the level in

width = int(raw_input("Width: "))
height = int(raw_input("Height: "))

solidBlocks = [",",".","-","="]

prevValue = -1
currentValue = 0

blockmapFile = open("blockmap.txt", "w+")

for i in range (0, height):
	currentLine = ""
	for i in range(0, width):
	
		currentValue = random.randint(0,3)
		while currentValue == prevValue:
			currentValue = random.randint(0,3)
			
		prevValue = currentValue
		
		currentLine += solidBlocks[currentValue];
		
	blockmapFile.write(currentLine+"\n")

blockmapFile.close()