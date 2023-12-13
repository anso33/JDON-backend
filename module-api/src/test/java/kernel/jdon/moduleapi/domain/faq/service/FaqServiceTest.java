package kernel.jdon.moduleapi.domain.faq.service;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import kernel.jdon.moduleapi.domain.faq.dto.FindFaqResponse;
import kernel.jdon.moduleapi.domain.faq.entity.Faq;
import kernel.jdon.moduleapi.domain.faq.repository.FaqRepository;

@SpringBootTest
class FaqServiceTest {

	@Autowired
	private FaqService faqService;
	@Autowired
	private FaqRepository faqRepository;

	@Test
	@DisplayName("faq를 상세조회 한다.")
	void getFaqDetailTest() {
		// given
		Faq faq = Faq.builder()
			.title("제목")
			.content("내용")
			.build();
		Faq savedFaq = faqRepository.save(faq);

		// when
		FindFaqResponse findFaqResponse = faqService.find(savedFaq.getId());

		// then
		assertThat(findFaqResponse).isNotNull();
	}

	@Test
	@DisplayName("faq 삭제를 확인한다.")
	public void removeFaqTest() {

		//given
		Faq faq = Faq.builder()
			.title("title")
			.content("content")
			.build();
		Faq savedFaq = faqRepository.save(faq);

		//when
		faqService.delete(savedFaq.getId());

		//then
		Assertions.assertThrows(IllegalArgumentException.class,
			() -> faqService.find(savedFaq.getId()));

	}
}