package com.zyadeh.kamel.command.impl;

import com.zyadeh.kamel.command.Command;
import com.zyadeh.kamel.dao.impl.DAO;
import com.zyadeh.kamel.entities.*;
import com.zyadeh.kamel.exceptions.ServiceException;
import com.zyadeh.kamel.obj.Page;
import com.zyadeh.kamel.service.impl.Service;
import com.zyadeh.kamel.statics.Dictionary;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class AnalysisCommand implements Command {
    @Override
    public Page execute(HttpServletRequest req) throws ServiceException {
        Page page = new Page("/pages/counting.jsp", true);

        Service service = new Service();
        DAO dao = new DAO();
        Text text = new Text();
        NounCount nounCount = new NounCount();
        VerbCount verbCount = new VerbCount();
        AdjectiveCount adjectiveCount = new AdjectiveCount();
        CorrectSentenceCount correctSentenceCount = new CorrectSentenceCount();
        IncorrectSentenceCount incorrectSentenceCount = new IncorrectSentenceCount();
        Count count = new Count();

        text.setText(req.getParameter("text"));

        String[] toWords = text.getText().split("\\s+");

        boolean[] noun = new boolean[toWords.length];
        boolean[] verb = new boolean[toWords.length];
        boolean[] adj = new boolean[toWords.length];

        int nounCounter = 0;
        int verbCounter = 0;
        int adjCounter = 0;

        for (int i = 0; i < toWords.length; i++) {
            if (Dictionary.nouns.contains(toWords[i])) {
                noun[i] = true;
                nounCounter++;
            } else {
                noun[i] = false;
            }
        }

        for (int i = 0; i < toWords.length; i++) {
            if (!noun[i]) {
                if (Dictionary.verbs.contains(toWords[i])) {
                    verb[i] = true;
                    verbCounter++;
                } else {
                    verb[i] = false;
                }
            }
        }

        for (int i = 0; i < toWords.length; i++) {
            if (!verb[i]) {
                if (Dictionary.adjectives.contains(toWords[i])) {
                    adj[i] = true;
                    adjCounter++;
                } else {
                    adj[i] = false;
                }
            }
        }

        boolean step1 = false;
        boolean conti = false;
        boolean conti2 = false;
        boolean step2 = false;
        boolean step3 = false;
        boolean step4 = false;
        boolean step5 = false;
        boolean step6 = false;
        boolean step7 = false;

        String str = text.getText().trim();
        String[] sentences = str.split(Pattern.quote("."));
        boolean[] correctSentence = new boolean[sentences.length];
        String lastWord = new String();

        for (int i = 0; i < sentences.length; i++) {
            String[] words = sentences[i].split("\\s+");
            for (int j = 0; j < words.length; j++) {
                if (Dictionary.nouns.contains(words[j]) && !step1) {
                    conti = true;
                    continue;
                } else if (conti) {
                    step1 = true;
                } else {
                    correctSentence[i] = false;
                    break;
                }

                if (Dictionary.verbs.contains(words[j]) && !step2) {
                    step2 = true;
                    continue;
                }

                if (Dictionary.nouns.contains(words[j]) && !step3) {
                    conti2 = true;
                    continue;
                } else if (conti2) {
                    step3 = true;
                } else {
                    correctSentence[i] = false;
                    break;
                }

                 if (Dictionary.adjectives.contains(words[j]) && !step4) {
                     step4 = true;
                     correctSentence[i] = true;
                 }

            }

        }

            for (int i = 0; i < sentences.length; i++) {
                if (!correctSentence[i]) {
                    String[] words = sentences[i].split("\\s+");
                    for (int j = 0; j < words.length; j++) {
                        if (Dictionary.verbs.contains(words[j])) {
                            step5 = true;
                            j++;
                            if (Dictionary.verbs.contains(words[j])) {
                                step5 = false;
                                correctSentence[i] = false;
                                break;
                            }
                        }
                        if (step5 && Dictionary.nouns.contains(words[j])) {
                            step6 = true;
                        }
                        if (step6 && Dictionary.adjectives.contains(words[j])) {
                            correctSentence[i] = words[words.length - 1].equals(words[j]);
                            step7 = true;
                        }
                        if (!step7) {
                            correctSentence[i] = false;
                        }
                    }
                }
            }


            int correctSentences = 0;
            int wrongSentences = 0;
            for (int i = 0; i < correctSentence.length; i++) {
                if (!correctSentence[i]) {
                    wrongSentences++;
                }
                if (correctSentence[i]) {
                    correctSentences++;
                }
            }

//        String[] correctSentencesCount = Arrays.stream(correctSentences).
//                filter(value -> value != null && value.length() > 0).toArray(String[]::new);
//        String[] wrongSentencesCount = Arrays.stream(wrongSentences).
//                filter(value -> value != null && value.length() > 0).toArray(String[]::new);
//        String[] countOfNouns = Arrays.stream(noun).
//                filter(value -> value != null && value.length() > 0).toArray(String[]::new);
//        String[] countOfVerbs = Arrays.stream(verb).
//                filter(value -> value != null && value.length() > 0).toArray(String[]::new);
//        String[] countOfAdjs = Arrays.stream(adj).
//                filter(value -> value != null && value.length() > 0).toArray(String[]::new);


            service.create(text);

            Text returningText = new Text();
            returningText = service.reading();
        System.out.println(returningText);
            nounCount.setNoun(nounCounter);
            verbCount.setVerbs(verbCounter);
            adjectiveCount.setAdj(adjCounter);
            correctSentenceCount.setCorrectSentences(correctSentences);
            incorrectSentenceCount.setIncorrectSentences(wrongSentences);

            count.setAdjectiveCount(adjectiveCount);
            count.setNounCount(nounCount);
            count.setVerbCount(verbCount);
            count.setCorrectSentenceCount(correctSentenceCount);
            count.setIncorrectSentenceCount(incorrectSentenceCount);
            HttpSession session = req.getSession();
            session.setAttribute("count", count);
            session.setAttribute("savedText", returningText);

            return page;
        }
    }