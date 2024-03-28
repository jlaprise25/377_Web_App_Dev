import os
import shutil

def rename_photos():
    path = input("What is the folder path?")
    prefix = input("What is the file name prefix?")
    i = 0
    files = os.listdir(path)
    files.sort()
    for filename in files:
        extension = filename.split(".")[1].lower()
        # print(extension)
        # print(filename)
        source = path + "/" + filename
        destination = path + "/" + prefix + str(i) + "." + extension
        os.rename(source, destination)
        i += 1

def copy_file():
    original = 'C:/Users/jerem/OneDrive/Pictures/dog/dog-puppy-on-garden-royalty-free-image-1586966191.jpg'
    filename, extension = original.split('.')
    for i in range(5):
        copy_filename = filename + '- copy' + str(i + 1) + '.' + extension
        # print(copy_filename)
        shutil.copyfile(original,copy_filename)


copy_file()
# rename_photos()