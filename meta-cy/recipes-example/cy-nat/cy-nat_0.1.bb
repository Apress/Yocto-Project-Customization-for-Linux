LICENSE = "CLOSED"

SRC_URI = "file://cy-tool.c"

S = "${WORKDIR}"

do_install() {
    install -d ${D}${bindir}
}

do_compile:class-native() { 
    ${CC} ${CFLAGS} ${LDFLAGS} cy-tool.c -o cy-tool
}

do_install:append:class-native() {
    install cy-tool ${D}${bindir}
}

DEPENDS:class-target = "cy-nat-native"

do_compile:append:class-target() {
    cy-tool < cy-tool.c > cy-target.c
    ${CC} ${CFLAGS} ${LDFLAGS} cy-target.c -o cy-target
}

do_install:append:class-target() {
    install cy-target ${D}${bindir}
}

BBCLASSEXTEND = "native"
