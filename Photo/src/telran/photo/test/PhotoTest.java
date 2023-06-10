package telran.photo.test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Comparator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import telran.photo.model.Album;
import telran.photo.model.AlbumImpl;
import telran.photo.model.Photo;

class PhotoTest {
Album album;
LocalDateTime data = LocalDateTime.now();
Photo[] ph = new Photo[6];
Comparator<Photo> comp = (p1,p2)->{
	int res = Integer.compare(p1.getAlumId(), p2.getAlumId());
	return res !=0? res: Integer.compare(p1.getPhotoId(), p2.getPhotoId());
};

	@BeforeEach
	void setUp() throws Exception {
		album = new AlbumImpl(6);
		ph[0] = new Photo(1, 1,"title1", "folder1", data.minusDays(2));//18
		ph[1] = new Photo(1, 2,"title2", "folder2", data.minusDays(3));//17
		ph[2] = new Photo(1, 3,"title3", "folder3", data.minusDays(8));//12
		ph[3] = new Photo(2, 1,"title1", "folder1", data.minusDays(1));//19
		ph[4] = new Photo(2, 4,"title4", "folder4", data.minusDays(5));//15
		ph[5] = new Photo(1, 4,"title4", "folder4", data.minusDays(7));//13
		for (int i = 0; i < ph.length-1; i++) {
			album.addPhoto(ph[i]);
		}
	}

	@Test
	void addPhotoTest() {
		assertTrue(album.addPhoto(ph[5]));
		assertEquals(ph[5], album.getPhotoFromAlbum(4, 1));
		assertEquals(6, album.size());
		assertFalse(album.addPhoto(ph[5]));
		
	}
	@Test
	void removePhotoTest() {
		assertFalse(album.removePhoto(4, 1));
		assertTrue(album.removePhoto(1, 1));
		assertNull(album.getPhotoFromAlbum(1, 1));
		assertEquals(4, album.size());
	}
	
	@Test
	void updatePhotoTest() {
		assertTrue(album.updatePhoto(1, 1, "newUrl"));
		assertEquals("newUrl", album.getPhotoFromAlbum(1, 1).getUrl());
	}
	@Test
	void getPhotoFromAlbumTest() {
		assertEquals(ph[0], album.getPhotoFromAlbum(1, 1));
		assertNull(album.getPhotoFromAlbum(4, 1));
	}
	
	@Test
	void getAllPhotoFromAlbumTest() {
		Photo[] actual =album.getAllPhotoFromAlbum(2);
		Arrays.sort(actual, comp);
		Photo[] expected = {ph[3], ph[4]};
		assertArrayEquals(expected, actual);
	}

	@Test
	void getPhotoBeetwenDatetest() {
		LocalDate ld = data.toLocalDate();
		Photo[] actuals = album.getPhotoBeetwenDate(ld.minusDays(5), ld.minusDays(2));//15 - 18
		Arrays.sort(actuals, comp);
		Photo[] expecteds = { ph[1] };
		assertArrayEquals(expecteds, actuals);
	}
	
	@Test
	void testSize() {
		assertEquals(5, album.size());
	}
}
