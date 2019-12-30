package com.briup.zhxypj.service.impl;

import com.briup.zhxypj.bean.*;
import com.briup.zhxypj.mapper.QqnMapper;
import com.briup.zhxypj.mapper.QuestionMapper;
import com.briup.zhxypj.mapper.QuestionnaireMapper;
import com.briup.zhxypj.service.IQuestionnaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class QuestionnaireServiceImpl implements IQuestionnaireService {
    @Autowired
    private QuestionnaireMapper questionnaireMapper;
    @Autowired
    private QuestionMapper questionMapper;
    @Autowired
    private QqnMapper qqnMapper;
    @Override
    public List<Questionnaire> findAll() throws RuntimeException {
        QuestionnaireExample example = new QuestionnaireExample();
        List<Questionnaire> questionnaires = questionnaireMapper.selectByExample(example);
        return questionnaires;
    }

    @Override
    public void delete(int id) throws RuntimeException {
        QqnExample example = new QqnExample();
        example.createCriteria().andQuestionnaireIdEqualTo(id);
        qqnMapper.deleteByExample(example);
        questionnaireMapper.deleteByPrimaryKey(id);

    }

    @Override
    public void saveOrUpdate(Questionnaire questionnaire, int[] ids) throws RuntimeException {
        if(questionnaire == null){
            questionnaire.setDate(new Date());

            questionnaireMapper.insert(questionnaire);
        }else{
            questionnaireMapper.updateByPrimaryKey(questionnaire);
        }
    }

    @Override
    public List<Question> selectAll() throws RuntimeException {
        QuestionExample example = new QuestionExample();
        List<Question> questions = questionMapper.selectByExample(example);

        return questions;
    }

    @Override
    public void insert(int question_id, int questionnaire_id) throws RuntimeException {
//        qqnMapper.insert(question_id,question_id);
    }


    @Override
    public Questionnaire findById(int id) throws RuntimeException {
       return  questionnaireMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Questionnaire> findByCondi(String word) throws RuntimeException {
        QuestionnaireExample example = new QuestionnaireExample();
        if(word == null || "".equals(word)){
            return findAll();
        }else{
            example.createCriteria().andNameLike(word);
            return questionnaireMapper.selectByExample(example);
        }
    }
}
