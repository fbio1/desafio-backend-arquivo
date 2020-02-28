package com.arquivoProcessador;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import com.arquivoProcessador.service.RegisterService;

public class FileProcessor {

	public static void main(String[] args) throws IOException, InterruptedException {
		RegisterService service = new RegisterService();
		
		Path inputPath = Paths.get(System.getProperty("user.home").concat(File.separator).concat("data")
				.concat(File.separator).concat("in"));
		Path outputPath = Paths.get(System.getProperty("user.home").concat(File.separator).concat("data")
				.concat(File.separator).concat("out"));

		FileFilter filter = new FileFilter() {
			public boolean accept(File file) {
				return file.getName().endsWith(".dat");
			}
		};

		File dir = new File(inputPath.toString());
		File[] files = dir.listFiles(filter);

		for (File arq : files) {
			String filename = arq.getName();
			Path outputFilePath = outputPath.resolve(filename.replace(".dat", ".done.dat"));

			System.out.println("Lendo arquivo de ".concat(arq.toString()));
			List<String> lines = Files.readAllLines(arq.toPath());

			System.out.println("processando...");
			service.registerAll(lines);

			try (BufferedWriter writer = Files.newBufferedWriter(outputFilePath)) {
				writer.write(service.getReportResult());
				System.out.println("Resultado do processamento em ".concat(outputFilePath.toString()));
			}
		}
		System.out.println("Finish");
	}

}
