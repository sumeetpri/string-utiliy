# It transforms stream of characters into a every alternate character as lower to upper
# It assumes empty character as also character stream, alpha num check is not required as
# upper and lower functions handles automatically
# Time complexity O(n)

def transform(sentence):
    size = len(sentence)
    collection = list(sentence)
    for i in range(0, size):
        if i % 2 == 0 and collection[i] != 'i':
            collection[i] = collection[i].upper()
        else:
            collection[i] = collection[i].lower()

    return ''.join(collection)


# It iterates using two pointers from left and right and if multiple of
# 2 index makes upper case and other as lower index
# Time complexity O(n/2)
def transform_fast(sentence):
    size = len(sentence)
    collection = list(sentence)
    i, j = 0, size - 1
    while i <= j:
        collection[i] = collection[i].lower()
        collection[j] = collection[j].lower()
        if collection[i] != 'i' and i % 2 == 0:
            collection[i] = collection[i].upper()
        if collection[j] != 'i' and j % 2 == 0:
            collection[j] = collection[j].upper()
        i += 1
        j -= 1
    return ''.join(collection)


# It alters the character and ignores any special character in between

def transform_ignore_special_char(sentence):
    size = len(sentence)
    collection = list(sentence)
    is_even = True
    for i in range(0, size):
        if collection[i] == ' ' or collection[i] == 'i' or collection[i] == 'I' or not collection[i].isalpha():
            continue
        if is_even:
            collection[i] = collection[i].upper()
            is_even = False
        else:
            collection[i] = collection[i].lower()
            is_even = True

    return ''.join(collection)


if __name__ == '__main__':
    sentence = '''The Cape starling (Lamprotornis nitens) is a medium-sized passerine bird in the starling family,
    Saturnine, found in southern Africa. It is a gregarious bird and forms large flocks outside the 
    breeding season. It usually feeds on the ground, often foraging alongside other species of starlings
    '''
    print transform(sentence)
    print transform_fast(sentence)
    print transform_fast('i')
    print transform_fast('AbCdEfi')
    print transform_fast('2222')
    print transform_ignore_special_char('2222    abcdE%7Ujk') # 2222    AbCdE%7uJk
    print transform_ignore_special_char('ia')   #iA
