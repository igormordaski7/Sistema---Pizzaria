public class RecheioDoce extends Recheio {
    public RecheioDoce(String nome, float preco, float tempPreparo) {
        super(nome, preco, tempPreparo);
    }

    @Override
    public String getSubTipo() {
        return "Doce";
    }

    public static void recheiosDoces() {
        
        Recheio r1 = new RecheioDoce("chocolate", 2.00f, 1);
        Recheio r2 = new RecheioDoce("chocolate-branco", 2.50f, 2);
        Recheio r3 = new RecheioDoce("coco-ralado", 1.75f, 1);
        Recheio r4 = new RecheioDoce("morango", 3.00f, 2);
        Recheio r5 = new RecheioDoce("banana", 2.00f, 1);
        Recheio r6 = new RecheioDoce("sorvete", 4.00f, 3);
        Recheio r7 = new RecheioDoce("abacaxi", 2.50f, 2);
        Recheio r8 = new RecheioDoce("leite condensado", 3.50f, 2);
        Recheio r9 = new RecheioDoce("canela", 1.80f, 1);
        Recheio r10 = new RecheioDoce("chocolate granulado", 2.25f, 1);
        Recheio r11 = new RecheioDoce("pessego", 3.00f, 2);
        Recheio r12 = new RecheioDoce("cereja", 3.57f, 2);
        Recheio r13 = new RecheioDoce("figo", 2.75f, 2);
        Recheio r14 = new RecheioDoce("nutela", 5.00f, 3);
        Recheio r15 = new RecheioDoce("kiwi", 3.00f, 2);
        Recheio r16 = new RecheioDoce("chantily", 2.50f, 2);
        Recheio r17 = new RecheioDoce("doce de leite", 3.00f, 2);
        Recheio r18 = new RecheioDoce("amendoim granulado", 2.00f, 2);
        Recheio r19 = new RecheioDoce("ovo maltine", 4.00f, 3);
        Recheio r20 = new RecheioDoce("suspiro", 2.60f, 1);
}
}