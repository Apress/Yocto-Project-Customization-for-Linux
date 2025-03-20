LICENSE = "CLOSED"
LIC_FILES_CHKSUM = ""

SRC_URI = "file:///home/giometti/yocto/examples/bindata/bindata-${PV}.tar.gz;subdir=${BPN}-${PV}"

inherit bin_package

INSANE_SKIP:${PN} += "already-stripped"

