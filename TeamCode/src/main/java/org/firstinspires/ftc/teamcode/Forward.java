package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name = "FTC Coding Camp")
public class Forward extends LinearOpMode {

    private DcMotor right_front, right_back, left_front, left_back;
    private DcMotor slider_extend, slider_pivot;
    private Servo claw_open, claw_rotate, claw_pivot;
    private DistanceSensor distance_sensor;

    @Override
    public void runOpMode() throws InterruptedException {
        right_front = hardwareMap.dcMotor.get("right_front");
        right_back = hardwareMap.dcMotor.get("right_back");
        left_front = hardwareMap.dcMotor.get("left_front");
        left_back = hardwareMap.dcMotor.get("right_front");

        claw_open = hardwareMap.servo.get("claw_open");

        left_back.setDirection(DcMotorSimple.Direction.REVERSE);

        telemetry.addData("Robot status", "Initialized");
        telemetry.update();

        waitForStart();

        moveMotorToPos(1000);

        if (gamepad1.a) {
            claw_open.setPosition(1);
        } else if (gamepad1.b) {
            claw_open.setPosition(0.5);
        } else {
            claw_open.setPosition(0);
        }
    }

    public void moveMotorToPos(int encoderPos) {
        right_front.setPower(0.5);
        while (right_front.getCurrentPosition()  < encoderPos) {
            telemetry.addData("Motor Position: ", right_front.getCurrentPosition());
            telemetry.update();
        }
    }
}

