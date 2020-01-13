package ru.shakirova.puzzle.service;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.shakirova.puzzle.repository.QuestionRepository;

@Service
public class QuestionService {

    private final QuestionRepository questionRepository;
    private final Logger logger;

    @Autowired
    public QuestionService(QuestionRepository questionRepository, Logger logger) {
        this.questionRepository = questionRepository;
        this.logger = logger;
    }

    public void log() {
        logger.
    }


}
