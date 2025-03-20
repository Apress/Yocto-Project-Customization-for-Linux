SUMMARY = "A module for monitoring memory usage of a python program"
MAINTAINER = "Rodolfo Giometti <giometti@enneenne.com>"
SECTION = "devel/python"
HOMEPAGE = "https://github.com/pythonprofilers/memory_profiler"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://COPYING;md5=cde4ca348bb7feea790673481be0d980"

SRC_URI = "https://files.pythonhosted.org/packages/b2/88/e1907e1ca3488f2d9507ca8b0ae1add7b1cd5d3ca2bc8e5b329382ea2c7b/memory_profiler-${PV}.tar.gz"
SRC_URI[md5sum] = "5fe93d5035288095c4f86ef69ee19f37"
SRC_URI[sha1sum] = "116c32efa5ea3612b616e269676e05c1fab86581"
SRC_URI[sha256sum] = "4e5b73d7864a1d1292fb76a03e82a3e78ef934d06828a698d9dada76da2067b0"
SRC_URI[sha384sum] = "7a9b686739ac1dd76c6778d9d820b8bde5d27f5294932cc146abe62bb79b3ac4ef316a4f2acc92273389a3473b6b144c"
SRC_URI[sha512sum] = "b4b4629133221252ad336871781225688ba704c8c19ef32385672e4f18e8a160e7d68b640bde8a34bafe212d9501f1b7f24ba742cfe29d57851966959ef3800a"

S = "${WORKDIR}/memory_profiler-${PV}"

inherit setuptools3

RDEPENDS:${PN} += "python3-psutil"
RDEPENDS:${PN} += "python3-asyncio python3-core python3-debugger python3-distutils python3-logging python3-misc python3-multiprocessing python3-numpy python3-shell"
