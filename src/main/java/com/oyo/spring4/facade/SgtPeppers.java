package com.oyo.spring4.facade;

import com.oyo.spring4.integration.CompactDisc;
import org.springframework.stereotype.Component;

/**
 * @author liurui
 * @date 2019/8/28 19:01
 */
@Component
public class SgtPeppers implements CompactDisc {

    private String title = "Sgt. Pepper's Lonely Hearts Club Band";
    private String artist = "The Beatles";

    @Override
    public void play() {
        System.out.println("Playing " + title + " by " + artist);
    }
}
