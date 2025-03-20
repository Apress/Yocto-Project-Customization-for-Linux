SUMMARY = "Python library for the NMEA 0183 protcol"
MAINTAINER = "Rodolfo Giometti <giometti@enneenne.com>"
SECTION = "console/network"
HOMEPAGE = "https://github.com/Knio/pynmea2"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=bb5e173bc54080cb25079199959ba6b6"

SRC_URI = "git://github.com/Knio/pynmea2.git;protocol=https;branch=master"

PV = "1.0+git${SRCPV}"
SRCREV = "c546442d1ba38e488f47ef8a190eb5e890260aa2"

S = "${WORKDIR}/git"

inherit setuptools3

RDEPENDS:${PN} += "python3-core python3-datetime python3-numbers"
