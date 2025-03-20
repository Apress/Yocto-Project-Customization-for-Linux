SUMMARY = "Implementation of Connectivity Fault Management protocol"
DESCRIPTION = "A user space implementation of the Connectivity Fault Management (CFM) protocol as defined in 802.1Q section 12.14."
MAINTAINER = "Rodolfo Giometti <giometti@enneenne.com>"
SECTION = "libs/network"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://LICENSE;md5=b234ee4d69f5fce4486a80fdaf4a4263"

SRC_URI = "git://github.com/microchip-ung/cfm;protocol=https;branch=master"

PV = "1.0+git${SRCPV}"
SRCREV = "2b431096fc280fab8cc5c4d636b09be217eb9965"

S = "${WORKDIR}/git"

DEPENDS = "libev libmnl libnl"

inherit cmake

EXTRA_OECMAKE = ""
