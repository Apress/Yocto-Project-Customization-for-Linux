SUMMARY = "User space implementation of MRP state machine"
DESCRIPTION = "A user space implementation of the Media Redundancy Protocol (MRP) state machine as described into the International Standard IEC 62439-2."
MAINTAINER = "Rodolfo Giometti <giometti@enneenne.com>"
SECTION = "net"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://LICENSE;md5=b234ee4d69f5fce4486a80fdaf4a4263"

SRC_URI = "git://github.com/giometti/umrp;protocol=https;branch=master"

PV = "1.0+git${SRCPV}"
SRCREV = "fb193eac1a2df51fe42e19d4ea36bb0157bda09f"

S = "${WORKDIR}/git"

DEPENDS = "libnl libmnl libev libcfm-netlink dbus"
RDEPENDS:${PN} = "libcfm-netlink dbus"

inherit pkgconfig cmake

EXTRA_OECMAKE = "-DMRP_HAVE_DBus1=ON"
