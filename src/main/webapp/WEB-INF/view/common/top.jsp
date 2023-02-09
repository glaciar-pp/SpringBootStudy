<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

    <nav class="navbar navbar-expand-sm bg-dark navbar-dark fixed-top">
        <div class="container-fluid">
            <ul class="navbar-nav">
                <a class="navbar-brand ms-5 me-5" href="#">
                    <img src="/img/logo.png" alt="Logo" style="height:36px;" class="rounded-3">
                </a>
                <li class="nav-item">
                    <a class="nav-link" href="/goodM/user/home"><i class="fa-solid fa-house"></i> Home</a>
                </li>
                <li class="nav-item ms-3">
                    <a class="nav-link ${menu eq 'genBoard' ? "active" : ''}" href="/goodM/genBoard/list?p=1&f=&q="><i class="far fa-list-alt"></i> 자유게시판</a>
                </li>
                <li class="nav-item ms-3">
                    <a class="nav-link ${menu eq 'infoBoard' ? "active" : ''}" href="/goodM/infoBoard/list?p=1&f=&q="><i class="far fa-list-alt"></i> 마음에 Good! 게시판</a>
                </li>
                <li class="nav-item ms-3">
                    <a class="nav-link ${menu eq 'user' ? "active" : ''}" href="/goodM/user/list/1"><i class="fas fa-user-friends"></i> My page</a>
                </li>
                <li class="nav-item dropdown ms-3"><!-- 수정대상이나 예시로 일단 남겨둠 -->
	                <a class="nav-link dropdown-toggle ${(menu eq 'api') ? "active" : ''}" href="#" data-bs-toggle="dropdown">
	                    <i class="fa-solid fa-cloud-arrow-down"></i> API's(수정대상)
	                </a>
	                <ul class="dropdown-menu">
	                    <li><a class="dropdown-item" href="/api/hotPlaces">Hot Places</a></li>
	                    <li><a class="dropdown-item" href="/api/translate">번역</a></li>
	                    <li><a class="dropdown-item" href="/api/sentiment">감성 분석</a></li>
	                    <li><hr class="dropdown-divider"></hr></li>
	                    <li><a class="dropdown-item" href="/api/detect">객체 검출</a></li>
	                    <li><a class="dropdown-item" href="/api/pose">Pose Estimation</a></li>
	                    <li><a class="dropdown-item" href="/api/speechRecog">음성 인식</a></li>
	                </ul>
	            </li>

                <li class="nav-item ms-3">
                    <a class="nav-link" href="/goodM/user/logout"><i class="fas fa-sign-out-alt"></i> 로그아웃</a>
                </li>
            </ul>
            <span class="navbar-text me-3">${uname}님 환영합니다.</span>
        </div>
    </nav>