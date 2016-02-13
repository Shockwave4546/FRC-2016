# FRC-2016
Code for Shockwave's 2016 robot, Chuck "the harbor freight express."

This year's robot (hopefully) features automated tracking of the goal as well as automated angle calculation and firing

# Common Problems
-Robot grabs null pointers (java.lang.nullPointerException error)

Check whatever the error is pointing to, usually a subsystem or initialization method. Ensure that every object being referenced has been initialized. In the case of a two-motor drivetrain, ensure that the inverted motor is being referred to as kRearRight or kRearLeft (The robotdrive class allocates two-motor drivetrains to the rear two motors). Another common fix is ensuring that RobotMap.init() is called in the robot's initialization method.

-Driver Station gives error "Unknown error status at edu.wpi.first.wpilibj.hal.HALUtil.checkStatus(HALUtil.java:51)" as well as no power to bridge/pnuematics 

Check fuses on the PDP

-PDP gives an unclearable sticky fault 

Check CAN bus order: TODO get proper order from Will

-Bridge conection is active, but no robot communication

Ensure that the radio is connected properly and fully booted, then press the reset button on the roborio to reboot it. DO NOT reboot the robot using the breaker, as this is caused by the roborio booting too quickly for it to recognize the radio.

# Useful debug info
-Roborio IP: roboRIO-4546-FRC.local

-Radio IP: 10.45.46.1

-Ping the robot to check connection

In admin command prompt, type "ping roboRIO-4546-FRC.local" If this fails, try above steps.

-Access roboRIO webdash

In Internet Explorer (NOT Chrome, Edge, or Safari) go to "http://roboRIO-4546-FRC.local/" For login, username "admin" leave password blank

Keep in mind this works in any of the ways the robot can be connected (wireless, ethernet, usb A-B)