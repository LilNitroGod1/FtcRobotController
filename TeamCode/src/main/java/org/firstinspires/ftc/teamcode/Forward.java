package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous(name = "telemetry test")
public class Forward extends LinearOpMode {

    @Override
    public void runOpMode() {

        waitForStart();

        telemetry.addLine("DS did not crash.");
    }
}
