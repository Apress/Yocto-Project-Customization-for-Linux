KERNEL_SRC = "git:///home/giometti/yocto/linux-engicam-nxp/"
SRCBRANCH = "5.15.71-cy"
SRCREV = "${AUTOREV}"
SRC_URI += "file://pps_ktimer.cfg \
            file://pps_ldisc.cfg \
            "

FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"
