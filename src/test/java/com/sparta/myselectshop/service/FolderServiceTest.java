package com.sparta.myselectshop.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.sparta.myselectshop.entity.Folder;
import com.sparta.myselectshop.entity.User;
import com.sparta.myselectshop.repository.FolderRepository;

@ExtendWith(MockitoExtension.class)
class FolderServiceTest {

	@Mock
	private FolderRepository folderRepository;

	@InjectMocks
	private FolderService folderService;

	private User user;

	@BeforeEach
	void setUp() {
		user = new User();
		user.setId(1L);
		user.setUsername("username");
	}

	@Test
	@DisplayName("폴더 추가(폴더명 중복 허용 o)")
	void addFolderTest1() {
		// given
		List<String> folderNames = Arrays.asList("folder1", "username");
		List<Folder> existFolderList = new ArrayList<>();

		given(folderRepository.findAllByUserAndNameIn(user, folderNames)).willReturn(existFolderList);

		// when
		folderService.addFolders(folderNames, user);

		// then
		then(folderRepository).should(times(1)).saveAll(anyList());
	}

	@Test
	@DisplayName("폴더 추가(폴더명 중복 허용 x)")
	void addFolderTest2() {
		// given
		List<String> folderNames = Arrays.asList("folder1", "username");
		List<Folder> existFolderList = Arrays.asList(new Folder("folder1", user));

		given(folderRepository.findAllByUserAndNameIn(user, folderNames)).willReturn(existFolderList);

		// when
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			folderService.addFolders(folderNames, user);
		});

		// then
		assertEquals("폴더명이 중복되었습니다.", exception.getMessage());
	}

}













