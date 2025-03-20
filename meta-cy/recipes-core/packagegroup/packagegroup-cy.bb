SUMMARY = "Custom CY Package Groups"
MAINTAINER = "Rodolfo Giometti <giometti@enneenne.com>"

inherit packagegroup

PACKAGES = " \
    ${PN}-examples \
    ${PN}-apps \
"

SUMMARY:${PN}-examples = "Custom CY Examples Package Groups"
SECTION:${PN}-examples = "examples"
RDEPENDS:${PN}-examples = "\
    hello \
    lhello \
"

SUMMARY:${PN}-apps = "Custom CY Applications Package Groups"
SECTION:${PN}-apps = "utils"
RDEPENDS:${PN}-apps = "\
    log2cb \
    umrp \
"
