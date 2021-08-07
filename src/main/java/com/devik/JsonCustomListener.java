package com.devik;

import antlr.JsonBaseListener;
import antlr.JsonParser;

public class JsonCustomListener extends JsonBaseListener {

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     *
     * @param ctx
     */
    @Override
    public void exitPair(JsonParser.PairContext ctx) {
        super.exitPair(ctx);
        System.out.println("Exiting from pair:");
        System.out.println(ctx.key().getText()+":"+ctx.value().getText());

    }
}
