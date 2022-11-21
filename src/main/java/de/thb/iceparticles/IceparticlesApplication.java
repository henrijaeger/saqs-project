package de.thb.iceparticles;

import de.thb.iceparticles.view.GuiFrame;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import javax.swing.*;

@SpringBootApplication
public class IceparticlesApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = new SpringApplicationBuilder(IceparticlesApplication.class)
				.headless(false).run(args);

		SwingUtilities.invokeLater(() -> ctx.getBean(GuiFrame.class).setVisible(true));
	}

}
