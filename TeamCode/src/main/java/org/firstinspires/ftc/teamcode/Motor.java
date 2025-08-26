package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name = "Motor2")
public class Motor extends LinearOpMode {
    private DcMotor right_front, right_back, left_front, left_back;

    @Override
    public void runOpMode() throws InterruptedException {

        right_front = hardwareMap.dcMotor.get("right_front");
        right_back = hardwareMap.dcMotor.get("right_back");
        left_front = hardwareMap.dcMotor.get("left_front");
        left_back = hardwareMap.dcMotor.get("left_back");

        left_back.setDirection(DcMotor.Direction.REVERSE);

        right_front.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        right_back.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        left_front.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        left_back.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        waitForStart();

        right_front.setPower(0.5);
        right_back.setPower(0.5);
        left_front.setPower(0.5);
        left_back.setPower(0.5);

        if (gamepad1.a) {
            right_front.setPower(0);
            right_back.setPower(0);
            left_front.setPower(0);
            left_back.setPower(0);
        }
    }
}

