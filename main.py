# It transforms stream of characters into a every alternate character as lower to upper
# It assumes empty character as also character stream
# Time complexity O(n)

def transform(sentence):
    size = len(sentence)
    collection = list(sentence)
    for i in range(0, size):
        if not collection[i].isalnum():
            continue
        if i % 2 == 0 and collection[i] != 'i':
            collection[i] = collection[i].upper()
        else:
            collection[i] = collection[i].lower()

    return ''.join(collection)


# It transforms stream of characters into a every alternate character as lower to upper
# It assumes empty character as also character stream
# Time complexity O(n/2)
def transformFast(sentence):
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


if __name__ == '__main__':
    sentence = '''The Cape starling (Lamprotornis nitens) is a medium-sized passerine bird in the starling family,
    Saturnine, found in southern Africa. It is a gregarious bird and forms large flocks outside the 
    breeding season. It usually feeds on the ground, often foraging alongside other species of starlings
    '''
    print transform(sentence)
    print transformFast(sentence)
    print transformFast('i')
    print transformFast('AbCdEfi')
    print transformFast('222iAA')