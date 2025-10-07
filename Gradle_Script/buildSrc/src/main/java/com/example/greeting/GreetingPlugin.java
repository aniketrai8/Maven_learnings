package com.example.greeting;

import org.gradle.api.Plugin;
import org.gradle.api.Project;

public class GreetingPlugin implements Plugin<Project> {
    @Override
    public void apply(Project project) {
        project.getTasks().register("fromBinaryPlugin", task -> {
            task.setGroup("Custom Greeting");
            task.setDescription("Prints a message from the Binary Plugin");
            task.doLast(t -> {
                System.out.println("🔧 Hello from the Binary Plugin!");
            });
        });
    }
}
