
# complete the left rotation function
# given an array and a value, rotate the array left by the given value

# O(n) time and O(n) space
def rotateLeft(arr, rotation):
    rotation = rotation%len(arr) * -1
    result = []
    # scan
    for i in range(len(arr)):
        # swap values
        result += [arr[rotation + i]]
    return result

# testing data and driver function call
arr = [1, 2, 3, 4, 5, 6]
rotation = 2
print(str(rotateLeft(arr, rotation)))