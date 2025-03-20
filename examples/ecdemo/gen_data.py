import os
import sys
import getopt
import struct

from fastecdsa import keys, curve

NAME = os.path.basename(sys.argv[0])

def c_print(file, name, data):
    file.write('uint8_t %s[SIGN_PUB_KEY_SIZE] = {\n' % name)
    for counter, v in enumerate(data):
        if counter % 8 == 0:
            file.write('\t');
        file.write('0x%02x, ' % v)
        if counter % 8 == 7:
            file.write('\n');
    file.write('\n};\n')

#
# Main
#

try:
    f = open("key.c", "w+")
except err:
    print(str(err))
    os.exit(1)

# generate a keypair (i.e. both keys) for curve P521
priv_key, pub_key = keys.gen_keypair(curve.P521)

print("pub x:", hex(pub_key.x))
print("pub y:", hex(pub_key.y))

xl = struct.unpack('B' * 66, pub_key.x.to_bytes(66, 'big'))
yl = struct.unpack('B' * 66, pub_key.y.to_bytes(66, 'big'))

f.write('#include "key.h"\n\n')
f.write('/*** Warning: auto-generated file! Do not modify ***/\n\n')
c_print(f, "pub_key_x", xl)
c_print(f, "pub_key_y", yl)

exit(0)
