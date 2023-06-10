package fesenko.homework.test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import fesenko.homework.model.ForumImpl;
import fesenko.homework.model.Post;

class ForumTest {
	ForumImpl forum = new ForumImpl();
	Post[] post = new Post[5];

	@BeforeEach
	void setUp() throws Exception {
		post[0] = new Post("author1", 1, "title1", "content1");
		post[1] = new Post("author2", 2, "title2", "content2");
		post[2] = new Post("author3", 3, "title3", "content3");
		post[3] = new Post("author2", 4, "title4", "content4");
		post[4] = new Post("author5", 5, "title5", "content5");
		for (int i = 0; i < post.length - 1; i++) {
			forum.addPost(post[i]);
		}

	}

	@Test
	void addPost() {
		assertTrue(forum.addPost(post[4]));
		assertEquals(post[4], forum.getPostById(5));
		assertEquals(5, forum.size());
		assertFalse(forum.addPost(post[4]));
	}

	@Test
	void removePost() {
		assertFalse(forum.removePost(5));
		assertTrue(forum.removePost(1));
		assertNull(forum.getPostById(1));
		assertEquals(3, forum.size());
	}

	@Test
	void updatePost() {
		assertTrue(forum.updatePost(2, "newContent"));
		assertEquals("newContent", forum.getPostById(2).getContent());
	}

	@Test
	void getPostById() {
		assertEquals(post[2], forum.getPostById(3));
		
	}

	@Test
	void getPostByAuthor() {
		Post[] actual = forum.getPostByAuthor("author2");
		Post[] expected = {post[1],post[3]};
		assertArrayEquals(expected, actual);
	}
	@Test
	void getPostByAuthorDate() {
		LocalDate ld = LocalDate.now();
		Post[] actual = forum.getPostByAuthor("author2",ld.minusDays(1),ld.plusDays(1));
		Post[] expected = {post[1],post[3]};
		assertArrayEquals(expected, actual);
		
		
	}
	@Test
	void size() {
		assertEquals(4, forum.size());
	}

}
