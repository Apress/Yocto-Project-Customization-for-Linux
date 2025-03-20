# Yocto-Project-Customization-for-Linux

Here the code from the book "Yocto Project Customization for Linux - The Essential Guide for Embedded Developers" written by Rodolfo Giometti and published by Apress Media LLC (ISBN 979-8-8688-1434-1).

These code examples are presented in the book in order to explain to the reader how to implements the several projects presented in the book.

License
=======
When not specified in each file header, all the code is published with the MIT License as reported into file LICENSE.txt in the root directory of this repository.

Downloading/updating the code
=============================

To get the latest version of these example codes, just use the command:

    $ git clone https://github.com/Apress/Yocto-Project-Customization-for-Linux.git

Warning
=======

Before using the code within the meta-cy directory, you should consider that some paths are referred to the author's home directory, as shown here:

    $ rgrep '/home/giometti' .
    ./recipes-kernel/khello/khello_git.bb:SRC_URI = "git:///home/giometti/yocto/examples/khello;branch=master"
    ./recipes-kernel/linux-engicam/linux-engicam_5.15.bbappend:KERNEL_SRC = "git:///home/giometti/yocto/linux-engicam-nxp/"
    ./recipes-bsp/u-boot-engicam/u-boot-engicam_2022.04.bbappend:UBOOT_SRC = "git:///home/giometti/yocto/u-boot-engicam-nxp-2022.04/"
    ...

So, you have to fix these path names before using this meta layer.

Enjoy! :-)
