#
# Copyright (C) 2021 The LineageOS Project
#
# SPDX-License-Identifier: Apache-2.0
#

# Inherit from those products. Most specific first.
$(call inherit-product, $(SRC_TARGET_DIR)/product/core_64_bit.mk)
$(call inherit-product, $(SRC_TARGET_DIR)/product/full_base_telephony.mk)

# Inherit from the device configuration.
$(call inherit-product, device/xiaomi/cmi/device.mk)

# Inherit from the Lineage configuration.
$(call inherit-product, vendor/aosp/config/common_full_phone.mk)

# Call the MiuiCamera setup
$(call inherit-product-if-exists, vendor/xiaomi/cmi-miuicamera/products/miuicamera.mk)

# Set Boot Animination Resolution
TARGET_BOOT_ANIMATION_RES := 1080

TARGET_SUPPORTS_QUICK_TAP := true
TARGET_CAMERA_USES_NEWER_HIDL_OVERRIDE_FORMAT = true

# Next-Gen Assistant
PRODUCT_PACKAGES += \
    NgaResources

PRODUCT_PACKAGES += \
    nga

PRODUCT_NAME := aosp_cmi
PRODUCT_DEVICE := cmi
PRODUCT_BRAND := Xiaomi
PRODUCT_MODEL := Mi 10 Pro
PRODUCT_MANUFACTURER := Xiaomi

PRODUCT_GMS_CLIENTID_BASE := android-xiaomi

BUILD_FINGERPRINT := Xiaomi/cmi/cmi:13/TKQ1.221114.001/V14.0.3.0.TJAEUXM:user/release-keys
