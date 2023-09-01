package com.sb.dg.prob;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static com.sb.dg.prob.MeshMessage.bfs;

class MeshMessageTest {

    @Test
    void testBfs() {
        List<String> exp = Arrays.asList(new String[]{"Ren", "Jayden", "Amelia", "Miguel"});
        System.out.println(bfs("Ren", "Miguel"));
        Assertions.assertEquals(exp, bfs("Ren", "Miguel"));
    }

    @Test
    void testBfs1() {
        System.out.println(bfs("Rem", "Miguel"));
        Assertions.assertEquals(null, bfs("Rem", "Miguel"));
    }

    @Test
    void testBfs2() {
        System.out.println(bfs("Rem", "Miguel"));
        Assertions.assertEquals(null, bfs("Rem", "Miguel"));
    }

    @Test
    void testBfs3() {
        List<String> exp = Arrays.asList(new String[]{"Amelia", "Adam"});
        System.out.println(bfs("Amelia", "Adam"));
        Assertions.assertEquals(exp, bfs("Amelia", "Adam"));
    }

    @Test
    void testBfs4() {
        List<String> exp = Arrays.asList(new String[]{ "Amelia"});
        System.out.println(bfs("Amelia", "Amelia"));
        Assertions.assertEquals(exp, bfs("Amelia", "Amelia"));
    }

}