package telran.memory.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import telran.memory.utils.MemoryService;

class MemoryServiceTest {
	int[] arr;

	@Test
	void test() {
		int maxMemory = MemoryService.getMaxAvailableMemory();
		boolean flag;
		try {
			arr = new int[maxMemory];
			flag = true;
		} catch (Error e) {
			flag = false;
		}
		assertTrue(flag);
		try {
			arr = new int[maxMemory + 1];
			flag = true;
		} catch (Error e) {
			flag = false;
		}
		assertFalse(flag);
	}

}
