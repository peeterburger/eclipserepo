package core;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class Finder {

	public static int find(byte[] array, byte[] pattern) {
		int nextByte = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] == pattern[nextByte]) {
				nextByte++;
				if (nextByte == pattern.length) {
					return i - pattern.length;
				}
			} else {
				nextByte = 0;
			}
		}
		return -1;
	}

	public static int find(String s, String p) {
		return find(s.getBytes(), p.getBytes());
	}

	public static void main(String[] args) throws IOException {
		byte[] array = Files.readAllBytes(new File("H:/Desktop/Sperrbildschirm Maturaball.png").toPath());
		String pattern = "ben isch a fag";

		System.out.println(find(array, pattern.getBytes()));
	}
}