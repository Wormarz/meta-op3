SUMMARY = "Simple test image"
DESCRIPTION = "A minimal image for testing"

IMAGE_FEATURES += "ssh-server-openssh"

IMAGE_INSTALL = "\
    packagegroup-core-boot \
    packagegroup-core-ssh-openssh \
"

inherit core-image
