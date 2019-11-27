import sys

prevWords = []
for line in sys.stdin:
    l = line.split()
    output = ""
    for word in l:
        if word.lower() in prevWords:
            output += ". "
        else:
            prevWords.append(word.lower())
            output += word + " "
    print(output[:-1])
