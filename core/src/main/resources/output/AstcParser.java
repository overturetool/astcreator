// $ANTLR 3.5 C:\\overture\\astCreator-github\\astCreator\\src\\main\\resources\\Astc.g 2013-09-06 20:14:17

package com.lausdahl.ast.creator.parser;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

import org.antlr.runtime.debug.*;
import java.io.IOException;
import org.antlr.runtime.tree.*;


@SuppressWarnings("all")
public class AstcParser extends DebugParser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "ASPECT_DCL", "ASSIGN", "AST", 
		"COLON", "COMMENT", "ESC_SEQ", "FIELD_DCL", "ID", "JAVANAME", "NormalChar", 
		"PACKAGES", "QUOTE", "SUBTYPE", "SpecialChar", "TOKENS", "WS", "'#'", 
		"'%'", "'&&'", "'('", "')'", "'*'", "'**'", "'+'", "';'", "'?'", "'['", 
		"']'", "'analysis'", "'base'", "'{'", "'|'", "'||'", "'}'"
	};
	public static final int EOF=-1;
	public static final int T__20=20;
	public static final int T__21=21;
	public static final int T__22=22;
	public static final int T__23=23;
	public static final int T__24=24;
	public static final int T__25=25;
	public static final int T__26=26;
	public static final int T__27=27;
	public static final int T__28=28;
	public static final int T__29=29;
	public static final int T__30=30;
	public static final int T__31=31;
	public static final int T__32=32;
	public static final int T__33=33;
	public static final int T__34=34;
	public static final int T__35=35;
	public static final int T__36=36;
	public static final int T__37=37;
	public static final int ASPECT_DCL=4;
	public static final int ASSIGN=5;
	public static final int AST=6;
	public static final int COLON=7;
	public static final int COMMENT=8;
	public static final int ESC_SEQ=9;
	public static final int FIELD_DCL=10;
	public static final int ID=11;
	public static final int JAVANAME=12;
	public static final int NormalChar=13;
	public static final int PACKAGES=14;
	public static final int QUOTE=15;
	public static final int SUBTYPE=16;
	public static final int SpecialChar=17;
	public static final int TOKENS=18;
	public static final int WS=19;

	// delegates
	public Parser[] getDelegates() {
		return new Parser[] {};
	}

	// delegators


	public static final String[] ruleNames = new String[] {
		"invalidRule", "aspectdcla", "name", "pkg", "definitions", "token", "alternative", 
		"production", "toks", "aspectdcl", "productionfields", "repeat", "aspectName", 
		"stringLiteral", "extends", "dd", "root", "ast", "productionfield"
	};

	public static final boolean[] decisionCanBacktrack = new boolean[] {
		false, // invalid decision
		false, false, false, false, false, false, false, false, false, false, 
		    false, false, false, false, false, false, false, false, false, false
	};

 
	public int ruleLevel = 0;
	public int getRuleLevel() { return ruleLevel; }
	public void incRuleLevel() { ruleLevel++; }
	public void decRuleLevel() { ruleLevel--; }
	public AstcParser(TokenStream input) {
		this(input, DebugEventSocketProxy.DEFAULT_DEBUGGER_PORT, new RecognizerSharedState());
	}
	public AstcParser(TokenStream input, int port, RecognizerSharedState state) {
		super(input, state);
		DebugEventSocketProxy proxy =
			new DebugEventSocketProxy(this,port,adaptor);
		setDebugListener(proxy);
		setTokenStream(new DebugTokenStream(input,proxy));
		try {
			proxy.handshake();
		}
		catch (IOException ioe) {
			reportError(ioe);
		}
		TreeAdaptor adap = new CommonTreeAdaptor();
		setTreeAdaptor(adap);
		proxy.setTreeAdaptor(adap);
	}

	public AstcParser(TokenStream input, DebugEventListener dbg) {
		super(input, dbg);
		 
		TreeAdaptor adap = new CommonTreeAdaptor();
		setTreeAdaptor(adap);

	}

	protected boolean evalPredicate(boolean result, String predicate) {
		dbg.semanticPredicate(result, predicate);
		return result;
	}

		protected DebugTreeAdaptor adaptor;
		public void setTreeAdaptor(TreeAdaptor adaptor) {
			this.adaptor = new DebugTreeAdaptor(dbg,adaptor);
		}
		public TreeAdaptor getTreeAdaptor() {
			return adaptor;
		}
	@Override public String[] getTokenNames() { return AstcParser.tokenNames; }
	@Override public String getGrammarFileName() { return "C:\\overture\\astCreator-github\\astCreator\\src\\main\\resources\\Astc.g"; }


	    private boolean mMessageCollectionEnabled = false;
	    private boolean mHasErrors = false;
	    private List<String> mMessages;
	    private List<RecognitionException> mExceptions = new ArrayList<RecognitionException>();

	    public boolean hasExceptions()
	    {
	        return mExceptions.size() > 0;
	    }

	    public List<RecognitionException> getExceptions()
	    {
	        return mExceptions;
	    }

	    public String getErrorMessage(RecognitionException e, String[] tokenNames)
	    {
	        String msg = super.getErrorMessage(e, tokenNames);
	        mExceptions.add(e);
	        return msg;
	    }

	    /**
	     *  Switches error message collection on or of.
	     *
	     *  The standard destination for parser error messages is <code>System.err</code>.
	     *  However, if <code>true</code> gets passed to this method this default
	     *  behaviour will be switched off and all error messages will be collected
	     *  instead of written to anywhere.
	     *
	     *  The default value is <code>false</code>.
	     *
	     *  @param pNewState  <code>true</code> if error messages should be collected.
	     */
	    public void enableErrorMessageCollection(boolean pNewState) {
	        mMessageCollectionEnabled = pNewState;
	        if (mMessages == null && mMessageCollectionEnabled) {
	            mMessages = new ArrayList<String>();
	        }
	    }
	    
	    /**
	     *  Collects an error message or passes the error message to <code>
	     *  super.emitErrorMessage(...)</code>.
	     *
	     *  The actual behaviour depends on whether collecting error messages
	     *  has been enabled or not.
	     *
	     *  @param pMessage  The error message.
	     */
	     @Override
	    public void emitErrorMessage(String pMessage) {
	        mHasErrors=true;
	        if (mMessageCollectionEnabled) {
	            mMessages.add(pMessage);
	        } else {
	            super.emitErrorMessage(pMessage);
	        }
	    }
	    
	    /**
	     *  Returns collected error messages.
	     *
	     *  @return  A list holding collected error messages or <code>null</code> if
	     *           collecting error messages hasn't been enabled. Of course, this
	     *           list may be empty if no error message has been emited.
	     */
	    public List<String> getMessages() {
	        return mMessages;
	    }
	    
	    /**
	     *  Tells if parsing a Java source has caused any error messages.
	     *
	     *  @return  <code>true</code> if parsing a Java source has caused at least one error message.
	     */
	    public boolean hasErrors() {
	        return mHasErrors;
	    }


	public static class extends_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "extends"
	// C:\\overture\\astCreator-github\\astCreator\\src\\main\\resources\\Astc.g:211:1: extends : SUBTYPE ID ;
	public final AstcParser.extends_return extends() throws  {
		AstcParser.extends_return retval = new AstcParser.extends_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token SUBTYPE1=null;
		Token ID2=null;

		Object SUBTYPE1_tree=null;
		Object ID2_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "extends");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(211, 0);

		try {
			// C:\\overture\\astCreator-github\\astCreator\\src\\main\\resources\\Astc.g:212:2: ( SUBTYPE ID )
			dbg.enterAlt(1);

			// C:\\overture\\astCreator-github\\astCreator\\src\\main\\resources\\Astc.g:212:4: SUBTYPE ID
			{
			root_0 = (Object)adaptor.nil();


			dbg.location(212,4);
			SUBTYPE1=(Token)match(input,SUBTYPE,FOLLOW_SUBTYPE_in_extends311); 
			SUBTYPE1_tree = (Object)adaptor.create(SUBTYPE1);
			adaptor.addChild(root_0, SUBTYPE1_tree);
			dbg.location(212,12);
			ID2=(Token)match(input,ID,FOLLOW_ID_in_extends313); 
			ID2_tree = (Object)adaptor.create(ID2);
			adaptor.addChild(root_0, ID2_tree);

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(213, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "extends");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "extends"


	public static class root_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "root"
	// C:\\overture\\astCreator-github\\astCreator\\src\\main\\resources\\Astc.g:233:1: root : pkg toks ast aspectdcl ;
	public final AstcParser.root_return root() throws  {
		AstcParser.root_return retval = new AstcParser.root_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope pkg3 =null;
		ParserRuleReturnScope toks4 =null;
		ParserRuleReturnScope ast5 =null;
		ParserRuleReturnScope aspectdcl6 =null;


		try { dbg.enterRule(getGrammarFileName(), "root");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(233, 0);

		try {
			// C:\\overture\\astCreator-github\\astCreator\\src\\main\\resources\\Astc.g:234:3: ( pkg toks ast aspectdcl )
			dbg.enterAlt(1);

			// C:\\overture\\astCreator-github\\astCreator\\src\\main\\resources\\Astc.g:234:5: pkg toks ast aspectdcl
			{
			root_0 = (Object)adaptor.nil();


			dbg.location(234,5);
			pushFollow(FOLLOW_pkg_in_root443);
			pkg3=pkg();
			state._fsp--;

			adaptor.addChild(root_0, pkg3.getTree());
			dbg.location(234,9);
			pushFollow(FOLLOW_toks_in_root445);
			toks4=toks();
			state._fsp--;

			adaptor.addChild(root_0, toks4.getTree());
			dbg.location(234,14);
			pushFollow(FOLLOW_ast_in_root447);
			ast5=ast();
			state._fsp--;

			adaptor.addChild(root_0, ast5.getTree());
			dbg.location(234,18);
			pushFollow(FOLLOW_aspectdcl_in_root449);
			aspectdcl6=aspectdcl();
			state._fsp--;

			adaptor.addChild(root_0, aspectdcl6.getTree());

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(235, 2);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "root");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "root"


	public static class pkg_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "pkg"
	// C:\\overture\\astCreator-github\\astCreator\\src\\main\\resources\\Astc.g:237:1: pkg : PACKAGES ^ ( 'base' JAVANAME ';' !)? ( 'analysis' JAVANAME ';' !)? ;
	public final AstcParser.pkg_return pkg() throws  {
		AstcParser.pkg_return retval = new AstcParser.pkg_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token PACKAGES7=null;
		Token string_literal8=null;
		Token JAVANAME9=null;
		Token char_literal10=null;
		Token string_literal11=null;
		Token JAVANAME12=null;
		Token char_literal13=null;

		Object PACKAGES7_tree=null;
		Object string_literal8_tree=null;
		Object JAVANAME9_tree=null;
		Object char_literal10_tree=null;
		Object string_literal11_tree=null;
		Object JAVANAME12_tree=null;
		Object char_literal13_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "pkg");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(237, 0);

		try {
			// C:\\overture\\astCreator-github\\astCreator\\src\\main\\resources\\Astc.g:238:3: ( PACKAGES ^ ( 'base' JAVANAME ';' !)? ( 'analysis' JAVANAME ';' !)? )
			dbg.enterAlt(1);

			// C:\\overture\\astCreator-github\\astCreator\\src\\main\\resources\\Astc.g:238:5: PACKAGES ^ ( 'base' JAVANAME ';' !)? ( 'analysis' JAVANAME ';' !)?
			{
			root_0 = (Object)adaptor.nil();


			dbg.location(238,13);
			PACKAGES7=(Token)match(input,PACKAGES,FOLLOW_PACKAGES_in_pkg467); 
			PACKAGES7_tree = (Object)adaptor.create(PACKAGES7);
			root_0 = (Object)adaptor.becomeRoot(PACKAGES7_tree, root_0);
			dbg.location(238,15);
			// C:\\overture\\astCreator-github\\astCreator\\src\\main\\resources\\Astc.g:238:15: ( 'base' JAVANAME ';' !)?
			int alt1=2;
			try { dbg.enterSubRule(1);
			try { dbg.enterDecision(1, decisionCanBacktrack[1]);

			int LA1_0 = input.LA(1);
			if ( (LA1_0==33) ) {
				alt1=1;
			}
			} finally {dbg.exitDecision(1);}

			switch (alt1) {
				case 1 :
					dbg.enterAlt(1);

					// C:\\overture\\astCreator-github\\astCreator\\src\\main\\resources\\Astc.g:238:16: 'base' JAVANAME ';' !
					{
					dbg.location(238,16);
					string_literal8=(Token)match(input,33,FOLLOW_33_in_pkg471); 
					string_literal8_tree = (Object)adaptor.create(string_literal8);
					adaptor.addChild(root_0, string_literal8_tree);
					dbg.location(238,23);
					JAVANAME9=(Token)match(input,JAVANAME,FOLLOW_JAVANAME_in_pkg473); 
					JAVANAME9_tree = (Object)adaptor.create(JAVANAME9);
					adaptor.addChild(root_0, JAVANAME9_tree);
					dbg.location(238,35);
					char_literal10=(Token)match(input,28,FOLLOW_28_in_pkg475); 
					}
					break;

			}
			} finally {dbg.exitSubRule(1);}
			dbg.location(238,40);
			// C:\\overture\\astCreator-github\\astCreator\\src\\main\\resources\\Astc.g:238:40: ( 'analysis' JAVANAME ';' !)?
			int alt2=2;
			try { dbg.enterSubRule(2);
			try { dbg.enterDecision(2, decisionCanBacktrack[2]);

			int LA2_0 = input.LA(1);
			if ( (LA2_0==32) ) {
				alt2=1;
			}
			} finally {dbg.exitDecision(2);}

			switch (alt2) {
				case 1 :
					dbg.enterAlt(1);

					// C:\\overture\\astCreator-github\\astCreator\\src\\main\\resources\\Astc.g:238:41: 'analysis' JAVANAME ';' !
					{
					dbg.location(238,41);
					string_literal11=(Token)match(input,32,FOLLOW_32_in_pkg482); 
					string_literal11_tree = (Object)adaptor.create(string_literal11);
					adaptor.addChild(root_0, string_literal11_tree);
					dbg.location(238,52);
					JAVANAME12=(Token)match(input,JAVANAME,FOLLOW_JAVANAME_in_pkg484); 
					JAVANAME12_tree = (Object)adaptor.create(JAVANAME12);
					adaptor.addChild(root_0, JAVANAME12_tree);
					dbg.location(238,64);
					char_literal13=(Token)match(input,28,FOLLOW_28_in_pkg486); 
					}
					break;

			}
			} finally {dbg.exitSubRule(2);}

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(239, 2);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "pkg");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "pkg"


	public static class ast_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "ast"
	// C:\\overture\\astCreator-github\\astCreator\\src\\main\\resources\\Astc.g:241:1: ast : AST ^ ( ( production )* ) ;
	public final AstcParser.ast_return ast() throws  {
		AstcParser.ast_return retval = new AstcParser.ast_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token AST14=null;
		ParserRuleReturnScope production15 =null;

		Object AST14_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "ast");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(241, 0);

		try {
			// C:\\overture\\astCreator-github\\astCreator\\src\\main\\resources\\Astc.g:242:3: ( AST ^ ( ( production )* ) )
			dbg.enterAlt(1);

			// C:\\overture\\astCreator-github\\astCreator\\src\\main\\resources\\Astc.g:242:5: AST ^ ( ( production )* )
			{
			root_0 = (Object)adaptor.nil();


			dbg.location(242,8);
			AST14=(Token)match(input,AST,FOLLOW_AST_in_ast505); 
			AST14_tree = (Object)adaptor.create(AST14);
			root_0 = (Object)adaptor.becomeRoot(AST14_tree, root_0);
			dbg.location(242,10);
			// C:\\overture\\astCreator-github\\astCreator\\src\\main\\resources\\Astc.g:242:10: ( ( production )* )
			dbg.enterAlt(1);

			// C:\\overture\\astCreator-github\\astCreator\\src\\main\\resources\\Astc.g:242:11: ( production )*
			{
			dbg.location(242,11);
			// C:\\overture\\astCreator-github\\astCreator\\src\\main\\resources\\Astc.g:242:11: ( production )*
			try { dbg.enterSubRule(3);

			loop3:
			while (true) {
				int alt3=2;
				try { dbg.enterDecision(3, decisionCanBacktrack[3]);

				int LA3_0 = input.LA(1);
				if ( (LA3_0==ID||LA3_0==20) ) {
					alt3=1;
				}

				} finally {dbg.exitDecision(3);}

				switch (alt3) {
				case 1 :
					dbg.enterAlt(1);

					// C:\\overture\\astCreator-github\\astCreator\\src\\main\\resources\\Astc.g:242:12: production
					{
					dbg.location(242,12);
					pushFollow(FOLLOW_production_in_ast510);
					production15=production();
					state._fsp--;

					adaptor.addChild(root_0, production15.getTree());

					}
					break;

				default :
					break loop3;
				}
			}
			} finally {dbg.exitSubRule(3);}

			}

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(243, 2);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "ast");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "ast"


	public static class toks_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "toks"
	// C:\\overture\\astCreator-github\\astCreator\\src\\main\\resources\\Astc.g:245:1: toks : TOKENS ^ ( ( token )* ) ;
	public final AstcParser.toks_return toks() throws  {
		AstcParser.toks_return retval = new AstcParser.toks_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token TOKENS16=null;
		ParserRuleReturnScope token17 =null;

		Object TOKENS16_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "toks");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(245, 0);

		try {
			// C:\\overture\\astCreator-github\\astCreator\\src\\main\\resources\\Astc.g:246:3: ( TOKENS ^ ( ( token )* ) )
			dbg.enterAlt(1);

			// C:\\overture\\astCreator-github\\astCreator\\src\\main\\resources\\Astc.g:246:5: TOKENS ^ ( ( token )* )
			{
			root_0 = (Object)adaptor.nil();


			dbg.location(246,11);
			TOKENS16=(Token)match(input,TOKENS,FOLLOW_TOKENS_in_toks528); 
			TOKENS16_tree = (Object)adaptor.create(TOKENS16);
			root_0 = (Object)adaptor.becomeRoot(TOKENS16_tree, root_0);
			dbg.location(246,13);
			// C:\\overture\\astCreator-github\\astCreator\\src\\main\\resources\\Astc.g:246:13: ( ( token )* )
			dbg.enterAlt(1);

			// C:\\overture\\astCreator-github\\astCreator\\src\\main\\resources\\Astc.g:246:14: ( token )*
			{
			dbg.location(246,14);
			// C:\\overture\\astCreator-github\\astCreator\\src\\main\\resources\\Astc.g:246:14: ( token )*
			try { dbg.enterSubRule(4);

			loop4:
			while (true) {
				int alt4=2;
				try { dbg.enterDecision(4, decisionCanBacktrack[4]);

				int LA4_0 = input.LA(1);
				if ( (LA4_0==ID) ) {
					alt4=1;
				}

				} finally {dbg.exitDecision(4);}

				switch (alt4) {
				case 1 :
					dbg.enterAlt(1);

					// C:\\overture\\astCreator-github\\astCreator\\src\\main\\resources\\Astc.g:246:15: token
					{
					dbg.location(246,15);
					pushFollow(FOLLOW_token_in_toks533);
					token17=token();
					state._fsp--;

					adaptor.addChild(root_0, token17.getTree());

					}
					break;

				default :
					break loop4;
				}
			}
			} finally {dbg.exitSubRule(4);}

			}

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(247, 2);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "toks");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "toks"


	public static class aspectdcl_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "aspectdcl"
	// C:\\overture\\astCreator-github\\astCreator\\src\\main\\resources\\Astc.g:249:1: aspectdcl : ASPECT_DCL ^ ( aspectdcla ';' !)* ;
	public final AstcParser.aspectdcl_return aspectdcl() throws  {
		AstcParser.aspectdcl_return retval = new AstcParser.aspectdcl_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token ASPECT_DCL18=null;
		Token char_literal20=null;
		ParserRuleReturnScope aspectdcla19 =null;

		Object ASPECT_DCL18_tree=null;
		Object char_literal20_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "aspectdcl");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(249, 0);

		try {
			// C:\\overture\\astCreator-github\\astCreator\\src\\main\\resources\\Astc.g:250:3: ( ASPECT_DCL ^ ( aspectdcla ';' !)* )
			dbg.enterAlt(1);

			// C:\\overture\\astCreator-github\\astCreator\\src\\main\\resources\\Astc.g:250:5: ASPECT_DCL ^ ( aspectdcla ';' !)*
			{
			root_0 = (Object)adaptor.nil();


			dbg.location(250,15);
			ASPECT_DCL18=(Token)match(input,ASPECT_DCL,FOLLOW_ASPECT_DCL_in_aspectdcl551); 
			ASPECT_DCL18_tree = (Object)adaptor.create(ASPECT_DCL18);
			root_0 = (Object)adaptor.becomeRoot(ASPECT_DCL18_tree, root_0);
			dbg.location(250,17);
			// C:\\overture\\astCreator-github\\astCreator\\src\\main\\resources\\Astc.g:250:17: ( aspectdcla ';' !)*
			try { dbg.enterSubRule(5);

			loop5:
			while (true) {
				int alt5=2;
				try { dbg.enterDecision(5, decisionCanBacktrack[5]);

				int LA5_0 = input.LA(1);
				if ( (LA5_0==21) ) {
					alt5=1;
				}

				} finally {dbg.exitDecision(5);}

				switch (alt5) {
				case 1 :
					dbg.enterAlt(1);

					// C:\\overture\\astCreator-github\\astCreator\\src\\main\\resources\\Astc.g:250:18: aspectdcla ';' !
					{
					dbg.location(250,18);
					pushFollow(FOLLOW_aspectdcla_in_aspectdcl555);
					aspectdcla19=aspectdcla();
					state._fsp--;

					adaptor.addChild(root_0, aspectdcla19.getTree());
					dbg.location(250,32);
					char_literal20=(Token)match(input,28,FOLLOW_28_in_aspectdcl557); 
					}
					break;

				default :
					break loop5;
				}
			}
			} finally {dbg.exitSubRule(5);}

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(251, 2);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "aspectdcl");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "aspectdcl"


	public static class aspectdcla_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "aspectdcla"
	// C:\\overture\\astCreator-github\\astCreator\\src\\main\\resources\\Astc.g:253:1: aspectdcla : '%' ^ dd ;
	public final AstcParser.aspectdcla_return aspectdcla() throws  {
		AstcParser.aspectdcla_return retval = new AstcParser.aspectdcla_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal21=null;
		ParserRuleReturnScope dd22 =null;

		Object char_literal21_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "aspectdcla");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(253, 0);

		try {
			// C:\\overture\\astCreator-github\\astCreator\\src\\main\\resources\\Astc.g:254:3: ( '%' ^ dd )
			dbg.enterAlt(1);

			// C:\\overture\\astCreator-github\\astCreator\\src\\main\\resources\\Astc.g:254:5: '%' ^ dd
			{
			root_0 = (Object)adaptor.nil();


			dbg.location(254,8);
			char_literal21=(Token)match(input,21,FOLLOW_21_in_aspectdcla575); 
			char_literal21_tree = (Object)adaptor.create(char_literal21);
			root_0 = (Object)adaptor.becomeRoot(char_literal21_tree, root_0);
			dbg.location(254,10);
			pushFollow(FOLLOW_dd_in_aspectdcla578);
			dd22=dd();
			state._fsp--;

			adaptor.addChild(root_0, dd22.getTree());

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(255, 2);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "aspectdcla");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "aspectdcla"


	public static class dd_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "dd"
	// C:\\overture\\astCreator-github\\astCreator\\src\\main\\resources\\Astc.g:257:1: dd : aspectName ASSIGN ( definitions )* -> ^( ID[\"ASPECT\"] aspectName ( definitions )* ) ;
	public final AstcParser.dd_return dd() throws  {
		AstcParser.dd_return retval = new AstcParser.dd_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token ASSIGN24=null;
		ParserRuleReturnScope aspectName23 =null;
		ParserRuleReturnScope definitions25 =null;

		Object ASSIGN24_tree=null;
		RewriteRuleTokenStream stream_ASSIGN=new RewriteRuleTokenStream(adaptor,"token ASSIGN");
		RewriteRuleSubtreeStream stream_aspectName=new RewriteRuleSubtreeStream(adaptor,"rule aspectName");
		RewriteRuleSubtreeStream stream_definitions=new RewriteRuleSubtreeStream(adaptor,"rule definitions");

		try { dbg.enterRule(getGrammarFileName(), "dd");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(257, 0);

		try {
			// C:\\overture\\astCreator-github\\astCreator\\src\\main\\resources\\Astc.g:258:3: ( aspectName ASSIGN ( definitions )* -> ^( ID[\"ASPECT\"] aspectName ( definitions )* ) )
			dbg.enterAlt(1);

			// C:\\overture\\astCreator-github\\astCreator\\src\\main\\resources\\Astc.g:258:4: aspectName ASSIGN ( definitions )*
			{
			dbg.location(258,4);
			pushFollow(FOLLOW_aspectName_in_dd594);
			aspectName23=aspectName();
			state._fsp--;

			stream_aspectName.add(aspectName23.getTree());dbg.location(258,15);
			ASSIGN24=(Token)match(input,ASSIGN,FOLLOW_ASSIGN_in_dd596);  
			stream_ASSIGN.add(ASSIGN24);
			dbg.location(258,22);
			// C:\\overture\\astCreator-github\\astCreator\\src\\main\\resources\\Astc.g:258:22: ( definitions )*
			try { dbg.enterSubRule(6);

			loop6:
			while (true) {
				int alt6=2;
				try { dbg.enterDecision(6, decisionCanBacktrack[6]);

				int LA6_0 = input.LA(1);
				if ( ((LA6_0 >= ID && LA6_0 <= JAVANAME)||LA6_0==23||LA6_0==30) ) {
					alt6=1;
				}

				} finally {dbg.exitDecision(6);}

				switch (alt6) {
				case 1 :
					dbg.enterAlt(1);

					// C:\\overture\\astCreator-github\\astCreator\\src\\main\\resources\\Astc.g:258:23: definitions
					{
					dbg.location(258,23);
					pushFollow(FOLLOW_definitions_in_dd599);
					definitions25=definitions();
					state._fsp--;

					stream_definitions.add(definitions25.getTree());
					}
					break;

				default :
					break loop6;
				}
			}
			} finally {dbg.exitSubRule(6);}

			// AST REWRITE
			// elements: aspectName, definitions
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 258:37: -> ^( ID[\"ASPECT\"] aspectName ( definitions )* )
			{
				dbg.location(258,40);
				// C:\\overture\\astCreator-github\\astCreator\\src\\main\\resources\\Astc.g:258:40: ^( ID[\"ASPECT\"] aspectName ( definitions )* )
				{
				Object root_1 = (Object)adaptor.nil();
				dbg.location(258,42);
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(ID, "ASPECT"), root_1);
				dbg.location(258,55);
				adaptor.addChild(root_1, stream_aspectName.nextTree());dbg.location(258,66);
				// C:\\overture\\astCreator-github\\astCreator\\src\\main\\resources\\Astc.g:258:66: ( definitions )*
				while ( stream_definitions.hasNext() ) {
					dbg.location(258,67);
					adaptor.addChild(root_1, stream_definitions.nextTree());
				}
				stream_definitions.reset();

				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(259, 2);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "dd");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "dd"


	public static class aspectName_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "aspectName"
	// C:\\overture\\astCreator-github\\astCreator\\src\\main\\resources\\Astc.g:261:1: aspectName : ID ^ ( '->' name )* ;
	public final AstcParser.aspectName_return aspectName() throws  {
		AstcParser.aspectName_return retval = new AstcParser.aspectName_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token ID26=null;
		Token string_literal27=null;
		ParserRuleReturnScope name28 =null;

		Object ID26_tree=null;
		Object string_literal27_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "aspectName");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(261, 0);

		try {
			// C:\\overture\\astCreator-github\\astCreator\\src\\main\\resources\\Astc.g:262:3: ( ID ^ ( '->' name )* )
			dbg.enterAlt(1);

			// C:\\overture\\astCreator-github\\astCreator\\src\\main\\resources\\Astc.g:262:5: ID ^ ( '->' name )*
			{
			root_0 = (Object)adaptor.nil();


			dbg.location(262,7);
			ID26=(Token)match(input,ID,FOLLOW_ID_in_aspectName629); 
			ID26_tree = (Object)adaptor.create(ID26);
			root_0 = (Object)adaptor.becomeRoot(ID26_tree, root_0);
			dbg.location(262,9);
			// C:\\overture\\astCreator-github\\astCreator\\src\\main\\resources\\Astc.g:262:9: ( '->' name )*
			try { dbg.enterSubRule(7);

			loop7:
			while (true) {
				int alt7=2;
				try { dbg.enterDecision(7, decisionCanBacktrack[7]);

				int LA7_0 = input.LA(1);
				if ( (LA7_0==FIELD_DCL) ) {
					alt7=1;
				}

				} finally {dbg.exitDecision(7);}

				switch (alt7) {
				case 1 :
					dbg.enterAlt(1);

					// C:\\overture\\astCreator-github\\astCreator\\src\\main\\resources\\Astc.g:262:10: '->' name
					{
					dbg.location(262,10);
					string_literal27=(Token)match(input,FIELD_DCL,FOLLOW_FIELD_DCL_in_aspectName633); 
					string_literal27_tree = (Object)adaptor.create(string_literal27);
					adaptor.addChild(root_0, string_literal27_tree);
					dbg.location(262,15);
					pushFollow(FOLLOW_name_in_aspectName635);
					name28=name();
					state._fsp--;

					adaptor.addChild(root_0, name28.getTree());

					}
					break;

				default :
					break loop7;
				}
			}
			} finally {dbg.exitSubRule(7);}

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(263, 2);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "aspectName");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "aspectName"


	public static class production_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "production"
	// C:\\overture\\astCreator-github\\astCreator\\src\\main\\resources\\Astc.g:266:1: production : name ( extends )? ( productionfields )? ( ASSIGN alternative ( '|' alternative )* )? ';' -> ^( ID[\"P\"] name ( productionfields )? ( alternative )* ) ;
	public final AstcParser.production_return production() throws  {
		AstcParser.production_return retval = new AstcParser.production_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token ASSIGN32=null;
		Token char_literal34=null;
		Token char_literal36=null;
		ParserRuleReturnScope name29 =null;
		ParserRuleReturnScope extends30 =null;
		ParserRuleReturnScope productionfields31 =null;
		ParserRuleReturnScope alternative33 =null;
		ParserRuleReturnScope alternative35 =null;

		Object ASSIGN32_tree=null;
		Object char_literal34_tree=null;
		Object char_literal36_tree=null;
		RewriteRuleTokenStream stream_35=new RewriteRuleTokenStream(adaptor,"token 35");
		RewriteRuleTokenStream stream_28=new RewriteRuleTokenStream(adaptor,"token 28");
		RewriteRuleTokenStream stream_ASSIGN=new RewriteRuleTokenStream(adaptor,"token ASSIGN");
		RewriteRuleSubtreeStream stream_extends=new RewriteRuleSubtreeStream(adaptor,"rule extends");
		RewriteRuleSubtreeStream stream_productionfields=new RewriteRuleSubtreeStream(adaptor,"rule productionfields");
		RewriteRuleSubtreeStream stream_name=new RewriteRuleSubtreeStream(adaptor,"rule name");
		RewriteRuleSubtreeStream stream_alternative=new RewriteRuleSubtreeStream(adaptor,"rule alternative");

		try { dbg.enterRule(getGrammarFileName(), "production");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(266, 0);

		try {
			// C:\\overture\\astCreator-github\\astCreator\\src\\main\\resources\\Astc.g:267:3: ( name ( extends )? ( productionfields )? ( ASSIGN alternative ( '|' alternative )* )? ';' -> ^( ID[\"P\"] name ( productionfields )? ( alternative )* ) )
			dbg.enterAlt(1);

			// C:\\overture\\astCreator-github\\astCreator\\src\\main\\resources\\Astc.g:267:5: name ( extends )? ( productionfields )? ( ASSIGN alternative ( '|' alternative )* )? ';'
			{
			dbg.location(267,5);
			pushFollow(FOLLOW_name_in_production651);
			name29=name();
			state._fsp--;

			stream_name.add(name29.getTree());dbg.location(267,10);
			// C:\\overture\\astCreator-github\\astCreator\\src\\main\\resources\\Astc.g:267:10: ( extends )?
			int alt8=2;
			try { dbg.enterSubRule(8);
			try { dbg.enterDecision(8, decisionCanBacktrack[8]);

			int LA8_0 = input.LA(1);
			if ( (LA8_0==SUBTYPE) ) {
				alt8=1;
			}
			} finally {dbg.exitDecision(8);}

			switch (alt8) {
				case 1 :
					dbg.enterAlt(1);

					// C:\\overture\\astCreator-github\\astCreator\\src\\main\\resources\\Astc.g:267:10: extends
					{
					dbg.location(267,10);
					pushFollow(FOLLOW_extends_in_production653);
					extends30=extends();
					state._fsp--;

					stream_extends.add(extends30.getTree());
					}
					break;

			}
			} finally {dbg.exitSubRule(8);}
			dbg.location(267,19);
			// C:\\overture\\astCreator-github\\astCreator\\src\\main\\resources\\Astc.g:267:19: ( productionfields )?
			int alt9=2;
			try { dbg.enterSubRule(9);
			try { dbg.enterDecision(9, decisionCanBacktrack[9]);

			int LA9_0 = input.LA(1);
			if ( (LA9_0==34) ) {
				alt9=1;
			}
			} finally {dbg.exitDecision(9);}

			switch (alt9) {
				case 1 :
					dbg.enterAlt(1);

					// C:\\overture\\astCreator-github\\astCreator\\src\\main\\resources\\Astc.g:267:19: productionfields
					{
					dbg.location(267,19);
					pushFollow(FOLLOW_productionfields_in_production656);
					productionfields31=productionfields();
					state._fsp--;

					stream_productionfields.add(productionfields31.getTree());
					}
					break;

			}
			} finally {dbg.exitSubRule(9);}
			dbg.location(267,37);
			// C:\\overture\\astCreator-github\\astCreator\\src\\main\\resources\\Astc.g:267:37: ( ASSIGN alternative ( '|' alternative )* )?
			int alt11=2;
			try { dbg.enterSubRule(11);
			try { dbg.enterDecision(11, decisionCanBacktrack[11]);

			int LA11_0 = input.LA(1);
			if ( (LA11_0==ASSIGN) ) {
				alt11=1;
			}
			} finally {dbg.exitDecision(11);}

			switch (alt11) {
				case 1 :
					dbg.enterAlt(1);

					// C:\\overture\\astCreator-github\\astCreator\\src\\main\\resources\\Astc.g:267:38: ASSIGN alternative ( '|' alternative )*
					{
					dbg.location(267,38);
					ASSIGN32=(Token)match(input,ASSIGN,FOLLOW_ASSIGN_in_production660);  
					stream_ASSIGN.add(ASSIGN32);
					dbg.location(267,45);
					pushFollow(FOLLOW_alternative_in_production662);
					alternative33=alternative();
					state._fsp--;

					stream_alternative.add(alternative33.getTree());dbg.location(267,57);
					// C:\\overture\\astCreator-github\\astCreator\\src\\main\\resources\\Astc.g:267:57: ( '|' alternative )*
					try { dbg.enterSubRule(10);

					loop10:
					while (true) {
						int alt10=2;
						try { dbg.enterDecision(10, decisionCanBacktrack[10]);

						int LA10_0 = input.LA(1);
						if ( (LA10_0==35) ) {
							alt10=1;
						}

						} finally {dbg.exitDecision(10);}

						switch (alt10) {
						case 1 :
							dbg.enterAlt(1);

							// C:\\overture\\astCreator-github\\astCreator\\src\\main\\resources\\Astc.g:267:58: '|' alternative
							{
							dbg.location(267,58);
							char_literal34=(Token)match(input,35,FOLLOW_35_in_production665);  
							stream_35.add(char_literal34);
							dbg.location(267,62);
							pushFollow(FOLLOW_alternative_in_production667);
							alternative35=alternative();
							state._fsp--;

							stream_alternative.add(alternative35.getTree());
							}
							break;

						default :
							break loop10;
						}
					}
					} finally {dbg.exitSubRule(10);}

					}
					break;

			}
			} finally {dbg.exitSubRule(11);}
			dbg.location(267,78);
			char_literal36=(Token)match(input,28,FOLLOW_28_in_production673);  
			stream_28.add(char_literal36);

			// AST REWRITE
			// elements: alternative, name, productionfields
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 267:82: -> ^( ID[\"P\"] name ( productionfields )? ( alternative )* )
			{
				dbg.location(267,85);
				// C:\\overture\\astCreator-github\\astCreator\\src\\main\\resources\\Astc.g:267:85: ^( ID[\"P\"] name ( productionfields )? ( alternative )* )
				{
				Object root_1 = (Object)adaptor.nil();
				dbg.location(267,87);
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(ID, "P"), root_1);
				dbg.location(267,95);
				adaptor.addChild(root_1, stream_name.nextTree());dbg.location(267,100);
				// C:\\overture\\astCreator-github\\astCreator\\src\\main\\resources\\Astc.g:267:100: ( productionfields )?
				if ( stream_productionfields.hasNext() ) {
					dbg.location(267,100);
					adaptor.addChild(root_1, stream_productionfields.nextTree());
				}
				stream_productionfields.reset();
				dbg.location(267,118);
				// C:\\overture\\astCreator-github\\astCreator\\src\\main\\resources\\Astc.g:267:118: ( alternative )*
				while ( stream_alternative.hasNext() ) {
					dbg.location(267,119);
					adaptor.addChild(root_1, stream_alternative.nextTree());
				}
				stream_alternative.reset();

				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(268, 2);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "production");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "production"


	public static class name_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "name"
	// C:\\overture\\astCreator-github\\astCreator\\src\\main\\resources\\Astc.g:270:1: name : ( ID ^| '#' ID -> ^( '#' ID ) );
	public final AstcParser.name_return name() throws  {
		AstcParser.name_return retval = new AstcParser.name_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token ID37=null;
		Token char_literal38=null;
		Token ID39=null;

		Object ID37_tree=null;
		Object char_literal38_tree=null;
		Object ID39_tree=null;
		RewriteRuleTokenStream stream_20=new RewriteRuleTokenStream(adaptor,"token 20");
		RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");

		try { dbg.enterRule(getGrammarFileName(), "name");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(270, 0);

		try {
			// C:\\overture\\astCreator-github\\astCreator\\src\\main\\resources\\Astc.g:271:3: ( ID ^| '#' ID -> ^( '#' ID ) )
			int alt12=2;
			try { dbg.enterDecision(12, decisionCanBacktrack[12]);

			int LA12_0 = input.LA(1);
			if ( (LA12_0==ID) ) {
				alt12=1;
			}
			else if ( (LA12_0==20) ) {
				alt12=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 12, 0, input);
				dbg.recognitionException(nvae);
				throw nvae;
			}

			} finally {dbg.exitDecision(12);}

			switch (alt12) {
				case 1 :
					dbg.enterAlt(1);

					// C:\\overture\\astCreator-github\\astCreator\\src\\main\\resources\\Astc.g:271:5: ID ^
					{
					root_0 = (Object)adaptor.nil();


					dbg.location(271,7);
					ID37=(Token)match(input,ID,FOLLOW_ID_in_name707); 
					ID37_tree = (Object)adaptor.create(ID37);
					root_0 = (Object)adaptor.becomeRoot(ID37_tree, root_0);

					}
					break;
				case 2 :
					dbg.enterAlt(2);

					// C:\\overture\\astCreator-github\\astCreator\\src\\main\\resources\\Astc.g:272:5: '#' ID
					{
					dbg.location(272,5);
					char_literal38=(Token)match(input,20,FOLLOW_20_in_name715);  
					stream_20.add(char_literal38);
					dbg.location(272,9);
					ID39=(Token)match(input,ID,FOLLOW_ID_in_name717);  
					stream_ID.add(ID39);

					// AST REWRITE
					// elements: ID, 20
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 272:11: -> ^( '#' ID )
					{
						dbg.location(272,13);
						// C:\\overture\\astCreator-github\\astCreator\\src\\main\\resources\\Astc.g:272:13: ^( '#' ID )
						{
						Object root_1 = (Object)adaptor.nil();
						dbg.location(272,15);
						root_1 = (Object)adaptor.becomeRoot(stream_20.nextNode(), root_1);
						dbg.location(272,19);
						adaptor.addChild(root_1, stream_ID.nextNode());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

					}
					break;

			}
			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(273, 2);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "name");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "name"


	public static class productionfields_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "productionfields"
	// C:\\overture\\astCreator-github\\astCreator\\src\\main\\resources\\Astc.g:277:1: productionfields : '{' ! FIELD_DCL ^ ( productionfield )* '}' !;
	public final AstcParser.productionfields_return productionfields() throws  {
		AstcParser.productionfields_return retval = new AstcParser.productionfields_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal40=null;
		Token FIELD_DCL41=null;
		Token char_literal43=null;
		ParserRuleReturnScope productionfield42 =null;

		Object char_literal40_tree=null;
		Object FIELD_DCL41_tree=null;
		Object char_literal43_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "productionfields");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(277, 0);

		try {
			// C:\\overture\\astCreator-github\\astCreator\\src\\main\\resources\\Astc.g:278:3: ( '{' ! FIELD_DCL ^ ( productionfield )* '}' !)
			dbg.enterAlt(1);

			// C:\\overture\\astCreator-github\\astCreator\\src\\main\\resources\\Astc.g:278:5: '{' ! FIELD_DCL ^ ( productionfield )* '}' !
			{
			root_0 = (Object)adaptor.nil();


			dbg.location(278,8);
			char_literal40=(Token)match(input,34,FOLLOW_34_in_productionfields742); dbg.location(278,19);
			FIELD_DCL41=(Token)match(input,FIELD_DCL,FOLLOW_FIELD_DCL_in_productionfields745); 
			FIELD_DCL41_tree = (Object)adaptor.create(FIELD_DCL41);
			root_0 = (Object)adaptor.becomeRoot(FIELD_DCL41_tree, root_0);
			dbg.location(278,21);
			// C:\\overture\\astCreator-github\\astCreator\\src\\main\\resources\\Astc.g:278:21: ( productionfield )*
			try { dbg.enterSubRule(13);

			loop13:
			while (true) {
				int alt13=2;
				try { dbg.enterDecision(13, decisionCanBacktrack[13]);

				int LA13_0 = input.LA(1);
				if ( (LA13_0==ID) ) {
					alt13=1;
				}

				} finally {dbg.exitDecision(13);}

				switch (alt13) {
				case 1 :
					dbg.enterAlt(1);

					// C:\\overture\\astCreator-github\\astCreator\\src\\main\\resources\\Astc.g:278:21: productionfield
					{
					dbg.location(278,21);
					pushFollow(FOLLOW_productionfield_in_productionfields748);
					productionfield42=productionfield();
					state._fsp--;

					adaptor.addChild(root_0, productionfield42.getTree());

					}
					break;

				default :
					break loop13;
				}
			}
			} finally {dbg.exitSubRule(13);}
			dbg.location(278,41);
			char_literal43=(Token)match(input,37,FOLLOW_37_in_productionfields751); 
			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(279, 2);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "productionfields");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "productionfields"


	public static class productionfield_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "productionfield"
	// C:\\overture\\astCreator-github\\astCreator\\src\\main\\resources\\Astc.g:281:1: productionfield : ID ^ ASSIGN ! QUOTE ! stringLiteral QUOTE !;
	public final AstcParser.productionfield_return productionfield() throws  {
		AstcParser.productionfield_return retval = new AstcParser.productionfield_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token ID44=null;
		Token ASSIGN45=null;
		Token QUOTE46=null;
		Token QUOTE48=null;
		ParserRuleReturnScope stringLiteral47 =null;

		Object ID44_tree=null;
		Object ASSIGN45_tree=null;
		Object QUOTE46_tree=null;
		Object QUOTE48_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "productionfield");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(281, 0);

		try {
			// C:\\overture\\astCreator-github\\astCreator\\src\\main\\resources\\Astc.g:282:3: ( ID ^ ASSIGN ! QUOTE ! stringLiteral QUOTE !)
			dbg.enterAlt(1);

			// C:\\overture\\astCreator-github\\astCreator\\src\\main\\resources\\Astc.g:282:5: ID ^ ASSIGN ! QUOTE ! stringLiteral QUOTE !
			{
			root_0 = (Object)adaptor.nil();


			dbg.location(282,7);
			ID44=(Token)match(input,ID,FOLLOW_ID_in_productionfield767); 
			ID44_tree = (Object)adaptor.create(ID44);
			root_0 = (Object)adaptor.becomeRoot(ID44_tree, root_0);
			dbg.location(282,15);
			ASSIGN45=(Token)match(input,ASSIGN,FOLLOW_ASSIGN_in_productionfield770); dbg.location(282,22);
			QUOTE46=(Token)match(input,QUOTE,FOLLOW_QUOTE_in_productionfield773); dbg.location(282,24);
			pushFollow(FOLLOW_stringLiteral_in_productionfield776);
			stringLiteral47=stringLiteral();
			state._fsp--;

			adaptor.addChild(root_0, stringLiteral47.getTree());
			dbg.location(282,43);
			QUOTE48=(Token)match(input,QUOTE,FOLLOW_QUOTE_in_productionfield778); 
			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(283, 2);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "productionfield");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "productionfield"


	public static class alternative_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "alternative"
	// C:\\overture\\astCreator-github\\astCreator\\src\\main\\resources\\Astc.g:285:1: alternative : ( ( '{' ID '}' )? ( definitions )* -> ^( ID ( definitions )* ) | '#' ID -> ^( ID[\"ALTERNATIVE_SUB_ROOT\"] ID ) );
	public final AstcParser.alternative_return alternative() throws  {
		AstcParser.alternative_return retval = new AstcParser.alternative_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal49=null;
		Token ID50=null;
		Token char_literal51=null;
		Token char_literal53=null;
		Token ID54=null;
		ParserRuleReturnScope definitions52 =null;

		Object char_literal49_tree=null;
		Object ID50_tree=null;
		Object char_literal51_tree=null;
		Object char_literal53_tree=null;
		Object ID54_tree=null;
		RewriteRuleTokenStream stream_20=new RewriteRuleTokenStream(adaptor,"token 20");
		RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
		RewriteRuleTokenStream stream_34=new RewriteRuleTokenStream(adaptor,"token 34");
		RewriteRuleTokenStream stream_37=new RewriteRuleTokenStream(adaptor,"token 37");
		RewriteRuleSubtreeStream stream_definitions=new RewriteRuleSubtreeStream(adaptor,"rule definitions");

		try { dbg.enterRule(getGrammarFileName(), "alternative");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(285, 0);

		try {
			// C:\\overture\\astCreator-github\\astCreator\\src\\main\\resources\\Astc.g:286:3: ( ( '{' ID '}' )? ( definitions )* -> ^( ID ( definitions )* ) | '#' ID -> ^( ID[\"ALTERNATIVE_SUB_ROOT\"] ID ) )
			int alt16=2;
			try { dbg.enterDecision(16, decisionCanBacktrack[16]);

			int LA16_0 = input.LA(1);
			if ( ((LA16_0 >= ID && LA16_0 <= JAVANAME)||LA16_0==23||LA16_0==28||LA16_0==30||(LA16_0 >= 34 && LA16_0 <= 35)) ) {
				alt16=1;
			}
			else if ( (LA16_0==20) ) {
				alt16=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 16, 0, input);
				dbg.recognitionException(nvae);
				throw nvae;
			}

			} finally {dbg.exitDecision(16);}

			switch (alt16) {
				case 1 :
					dbg.enterAlt(1);

					// C:\\overture\\astCreator-github\\astCreator\\src\\main\\resources\\Astc.g:286:5: ( '{' ID '}' )? ( definitions )*
					{
					dbg.location(286,5);
					// C:\\overture\\astCreator-github\\astCreator\\src\\main\\resources\\Astc.g:286:5: ( '{' ID '}' )?
					int alt14=2;
					try { dbg.enterSubRule(14);
					try { dbg.enterDecision(14, decisionCanBacktrack[14]);

					int LA14_0 = input.LA(1);
					if ( (LA14_0==34) ) {
						alt14=1;
					}
					} finally {dbg.exitDecision(14);}

					switch (alt14) {
						case 1 :
							dbg.enterAlt(1);

							// C:\\overture\\astCreator-github\\astCreator\\src\\main\\resources\\Astc.g:286:6: '{' ID '}'
							{
							dbg.location(286,6);
							char_literal49=(Token)match(input,34,FOLLOW_34_in_alternative794);  
							stream_34.add(char_literal49);
							dbg.location(286,10);
							ID50=(Token)match(input,ID,FOLLOW_ID_in_alternative796);  
							stream_ID.add(ID50);
							dbg.location(286,13);
							char_literal51=(Token)match(input,37,FOLLOW_37_in_alternative798);  
							stream_37.add(char_literal51);

							}
							break;

					}
					} finally {dbg.exitSubRule(14);}
					dbg.location(286,19);
					// C:\\overture\\astCreator-github\\astCreator\\src\\main\\resources\\Astc.g:286:19: ( definitions )*
					try { dbg.enterSubRule(15);

					loop15:
					while (true) {
						int alt15=2;
						try { dbg.enterDecision(15, decisionCanBacktrack[15]);

						int LA15_0 = input.LA(1);
						if ( ((LA15_0 >= ID && LA15_0 <= JAVANAME)||LA15_0==23||LA15_0==30) ) {
							alt15=1;
						}

						} finally {dbg.exitDecision(15);}

						switch (alt15) {
						case 1 :
							dbg.enterAlt(1);

							// C:\\overture\\astCreator-github\\astCreator\\src\\main\\resources\\Astc.g:286:20: definitions
							{
							dbg.location(286,20);
							pushFollow(FOLLOW_definitions_in_alternative803);
							definitions52=definitions();
							state._fsp--;

							stream_definitions.add(definitions52.getTree());
							}
							break;

						default :
							break loop15;
						}
					}
					} finally {dbg.exitSubRule(15);}

					// AST REWRITE
					// elements: definitions, ID
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 286:34: -> ^( ID ( definitions )* )
					{
						dbg.location(286,37);
						// C:\\overture\\astCreator-github\\astCreator\\src\\main\\resources\\Astc.g:286:37: ^( ID ( definitions )* )
						{
						Object root_1 = (Object)adaptor.nil();
						dbg.location(286,39);
						root_1 = (Object)adaptor.becomeRoot(stream_ID.nextNode(), root_1);
						dbg.location(286,42);
						// C:\\overture\\astCreator-github\\astCreator\\src\\main\\resources\\Astc.g:286:42: ( definitions )*
						while ( stream_definitions.hasNext() ) {
							dbg.location(286,43);
							adaptor.addChild(root_1, stream_definitions.nextTree());
						}
						stream_definitions.reset();

						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

					}
					break;
				case 2 :
					dbg.enterAlt(2);

					// C:\\overture\\astCreator-github\\astCreator\\src\\main\\resources\\Astc.g:287:5: '#' ID
					{
					dbg.location(287,5);
					char_literal53=(Token)match(input,20,FOLLOW_20_in_alternative822);  
					stream_20.add(char_literal53);
					dbg.location(287,9);
					ID54=(Token)match(input,ID,FOLLOW_ID_in_alternative824);  
					stream_ID.add(ID54);

					// AST REWRITE
					// elements: ID, ID
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 287:12: -> ^( ID[\"ALTERNATIVE_SUB_ROOT\"] ID )
					{
						dbg.location(287,15);
						// C:\\overture\\astCreator-github\\astCreator\\src\\main\\resources\\Astc.g:287:15: ^( ID[\"ALTERNATIVE_SUB_ROOT\"] ID )
						{
						Object root_1 = (Object)adaptor.nil();
						dbg.location(287,17);
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(ID, "ALTERNATIVE_SUB_ROOT"), root_1);
						dbg.location(287,44);
						adaptor.addChild(root_1, stream_ID.nextNode());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

					}
					break;

			}
			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(288, 2);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "alternative");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "alternative"


	public static class definitions_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "definitions"
	// C:\\overture\\astCreator-github\\astCreator\\src\\main\\resources\\Astc.g:290:1: definitions : ( ( '[' ID ']' ! ':' !)? | ( '(' ID ')' ! ':' !) ) ( ID | JAVANAME ) ^ ( repeat )? ;
	public final AstcParser.definitions_return definitions() throws  {
		AstcParser.definitions_return retval = new AstcParser.definitions_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal55=null;
		Token ID56=null;
		Token char_literal57=null;
		Token char_literal58=null;
		Token char_literal59=null;
		Token ID60=null;
		Token char_literal61=null;
		Token char_literal62=null;
		Token set63=null;
		ParserRuleReturnScope repeat64 =null;

		Object char_literal55_tree=null;
		Object ID56_tree=null;
		Object char_literal57_tree=null;
		Object char_literal58_tree=null;
		Object char_literal59_tree=null;
		Object ID60_tree=null;
		Object char_literal61_tree=null;
		Object char_literal62_tree=null;
		Object set63_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "definitions");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(290, 0);

		try {
			// C:\\overture\\astCreator-github\\astCreator\\src\\main\\resources\\Astc.g:291:3: ( ( ( '[' ID ']' ! ':' !)? | ( '(' ID ')' ! ':' !) ) ( ID | JAVANAME ) ^ ( repeat )? )
			dbg.enterAlt(1);

			// C:\\overture\\astCreator-github\\astCreator\\src\\main\\resources\\Astc.g:291:5: ( ( '[' ID ']' ! ':' !)? | ( '(' ID ')' ! ':' !) ) ( ID | JAVANAME ) ^ ( repeat )?
			{
			root_0 = (Object)adaptor.nil();


			dbg.location(291,5);
			// C:\\overture\\astCreator-github\\astCreator\\src\\main\\resources\\Astc.g:291:5: ( ( '[' ID ']' ! ':' !)? | ( '(' ID ')' ! ':' !) )
			int alt18=2;
			try { dbg.enterSubRule(18);
			try { dbg.enterDecision(18, decisionCanBacktrack[18]);

			int LA18_0 = input.LA(1);
			if ( ((LA18_0 >= ID && LA18_0 <= JAVANAME)||LA18_0==30) ) {
				alt18=1;
			}
			else if ( (LA18_0==23) ) {
				alt18=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 18, 0, input);
				dbg.recognitionException(nvae);
				throw nvae;
			}

			} finally {dbg.exitDecision(18);}

			switch (alt18) {
				case 1 :
					dbg.enterAlt(1);

					// C:\\overture\\astCreator-github\\astCreator\\src\\main\\resources\\Astc.g:291:6: ( '[' ID ']' ! ':' !)?
					{
					dbg.location(291,6);
					// C:\\overture\\astCreator-github\\astCreator\\src\\main\\resources\\Astc.g:291:6: ( '[' ID ']' ! ':' !)?
					int alt17=2;
					try { dbg.enterSubRule(17);
					try { dbg.enterDecision(17, decisionCanBacktrack[17]);

					int LA17_0 = input.LA(1);
					if ( (LA17_0==30) ) {
						alt17=1;
					}
					} finally {dbg.exitDecision(17);}

					switch (alt17) {
						case 1 :
							dbg.enterAlt(1);

							// C:\\overture\\astCreator-github\\astCreator\\src\\main\\resources\\Astc.g:291:7: '[' ID ']' ! ':' !
							{
							dbg.location(291,7);
							char_literal55=(Token)match(input,30,FOLLOW_30_in_definitions850); 
							char_literal55_tree = (Object)adaptor.create(char_literal55);
							adaptor.addChild(root_0, char_literal55_tree);
							dbg.location(291,11);
							ID56=(Token)match(input,ID,FOLLOW_ID_in_definitions852); 
							ID56_tree = (Object)adaptor.create(ID56);
							adaptor.addChild(root_0, ID56_tree);
							dbg.location(291,17);
							char_literal57=(Token)match(input,31,FOLLOW_31_in_definitions854); dbg.location(291,22);
							char_literal58=(Token)match(input,COLON,FOLLOW_COLON_in_definitions857); 
							}
							break;

					}
					} finally {dbg.exitSubRule(17);}

					}
					break;
				case 2 :
					dbg.enterAlt(2);

					// C:\\overture\\astCreator-github\\astCreator\\src\\main\\resources\\Astc.g:291:27: ( '(' ID ')' ! ':' !)
					{
					dbg.location(291,27);
					// C:\\overture\\astCreator-github\\astCreator\\src\\main\\resources\\Astc.g:291:27: ( '(' ID ')' ! ':' !)
					dbg.enterAlt(1);

					// C:\\overture\\astCreator-github\\astCreator\\src\\main\\resources\\Astc.g:291:28: '(' ID ')' ! ':' !
					{
					dbg.location(291,28);
					char_literal59=(Token)match(input,23,FOLLOW_23_in_definitions864); 
					char_literal59_tree = (Object)adaptor.create(char_literal59);
					adaptor.addChild(root_0, char_literal59_tree);
					dbg.location(291,32);
					ID60=(Token)match(input,ID,FOLLOW_ID_in_definitions866); 
					ID60_tree = (Object)adaptor.create(ID60);
					adaptor.addChild(root_0, ID60_tree);
					dbg.location(291,38);
					char_literal61=(Token)match(input,24,FOLLOW_24_in_definitions868); dbg.location(291,43);
					char_literal62=(Token)match(input,COLON,FOLLOW_COLON_in_definitions871); 
					}

					}
					break;

			}
			} finally {dbg.exitSubRule(18);}
			dbg.location(291,62);
			set63=input.LT(1);
			set63=input.LT(1);
			if ( (input.LA(1) >= ID && input.LA(1) <= JAVANAME) ) {
				input.consume();
				root_0 = (Object)adaptor.becomeRoot((Object)adaptor.create(set63), root_0);
				state.errorRecovery=false;
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				dbg.recognitionException(mse);
				throw mse;
			}dbg.location(291,64);
			// C:\\overture\\astCreator-github\\astCreator\\src\\main\\resources\\Astc.g:291:64: ( repeat )?
			int alt19=2;
			try { dbg.enterSubRule(19);
			try { dbg.enterDecision(19, decisionCanBacktrack[19]);

			int LA19_0 = input.LA(1);
			if ( ((LA19_0 >= 25 && LA19_0 <= 27)||LA19_0==29) ) {
				alt19=1;
			}
			} finally {dbg.exitDecision(19);}

			switch (alt19) {
				case 1 :
					dbg.enterAlt(1);

					// C:\\overture\\astCreator-github\\astCreator\\src\\main\\resources\\Astc.g:291:65: repeat
					{
					dbg.location(291,65);
					pushFollow(FOLLOW_repeat_in_definitions886);
					repeat64=repeat();
					state._fsp--;

					adaptor.addChild(root_0, repeat64.getTree());

					}
					break;

			}
			} finally {dbg.exitSubRule(19);}

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(293, 2);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "definitions");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "definitions"


	public static class repeat_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "repeat"
	// C:\\overture\\astCreator-github\\astCreator\\src\\main\\resources\\Astc.g:305:1: repeat : ( '?' | '*' | '**' | '+' );
	public final AstcParser.repeat_return repeat() throws  {
		AstcParser.repeat_return retval = new AstcParser.repeat_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token set65=null;

		Object set65_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "repeat");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(305, 0);

		try {
			// C:\\overture\\astCreator-github\\astCreator\\src\\main\\resources\\Astc.g:306:3: ( '?' | '*' | '**' | '+' )
			dbg.enterAlt(1);

			// C:\\overture\\astCreator-github\\astCreator\\src\\main\\resources\\Astc.g:
			{
			root_0 = (Object)adaptor.nil();


			dbg.location(306,3);
			set65=input.LT(1);
			if ( (input.LA(1) >= 25 && input.LA(1) <= 27)||input.LA(1)==29 ) {
				input.consume();
				adaptor.addChild(root_0, (Object)adaptor.create(set65));
				state.errorRecovery=false;
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				dbg.recognitionException(mse);
				throw mse;
			}
			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(310, 2);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "repeat");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "repeat"


	public static class token_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "token"
	// C:\\overture\\astCreator-github\\astCreator\\src\\main\\resources\\Astc.g:313:1: token : ID ^ ASSIGN ! QUOTE ! stringLiteral QUOTE ! ';' !;
	public final AstcParser.token_return token() throws  {
		AstcParser.token_return retval = new AstcParser.token_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token ID66=null;
		Token ASSIGN67=null;
		Token QUOTE68=null;
		Token QUOTE70=null;
		Token char_literal71=null;
		ParserRuleReturnScope stringLiteral69 =null;

		Object ID66_tree=null;
		Object ASSIGN67_tree=null;
		Object QUOTE68_tree=null;
		Object QUOTE70_tree=null;
		Object char_literal71_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "token");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(313, 0);

		try {
			// C:\\overture\\astCreator-github\\astCreator\\src\\main\\resources\\Astc.g:314:3: ( ID ^ ASSIGN ! QUOTE ! stringLiteral QUOTE ! ';' !)
			dbg.enterAlt(1);

			// C:\\overture\\astCreator-github\\astCreator\\src\\main\\resources\\Astc.g:314:5: ID ^ ASSIGN ! QUOTE ! stringLiteral QUOTE ! ';' !
			{
			root_0 = (Object)adaptor.nil();


			dbg.location(314,7);
			ID66=(Token)match(input,ID,FOLLOW_ID_in_token954); 
			ID66_tree = (Object)adaptor.create(ID66);
			root_0 = (Object)adaptor.becomeRoot(ID66_tree, root_0);
			dbg.location(314,15);
			ASSIGN67=(Token)match(input,ASSIGN,FOLLOW_ASSIGN_in_token957); dbg.location(314,22);
			QUOTE68=(Token)match(input,QUOTE,FOLLOW_QUOTE_in_token960); dbg.location(314,24);
			pushFollow(FOLLOW_stringLiteral_in_token963);
			stringLiteral69=stringLiteral();
			state._fsp--;

			adaptor.addChild(root_0, stringLiteral69.getTree());
			dbg.location(314,43);
			QUOTE70=(Token)match(input,QUOTE,FOLLOW_QUOTE_in_token965); dbg.location(314,48);
			char_literal71=(Token)match(input,28,FOLLOW_28_in_token968); 
			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(315, 2);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "token");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "token"


	public static class stringLiteral_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "stringLiteral"
	// C:\\overture\\astCreator-github\\astCreator\\src\\main\\resources\\Astc.g:317:1: stringLiteral : ( ID | NormalChar | '+' | '||' | '&&' | ( ':' ) !| JAVANAME )* ;
	public final AstcParser.stringLiteral_return stringLiteral() throws  {
		AstcParser.stringLiteral_return retval = new AstcParser.stringLiteral_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token ID72=null;
		Token NormalChar73=null;
		Token char_literal74=null;
		Token string_literal75=null;
		Token string_literal76=null;
		Token char_literal77=null;
		Token JAVANAME78=null;

		Object ID72_tree=null;
		Object NormalChar73_tree=null;
		Object char_literal74_tree=null;
		Object string_literal75_tree=null;
		Object string_literal76_tree=null;
		Object char_literal77_tree=null;
		Object JAVANAME78_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "stringLiteral");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(317, 0);

		try {
			// C:\\overture\\astCreator-github\\astCreator\\src\\main\\resources\\Astc.g:318:5: ( ( ID | NormalChar | '+' | '||' | '&&' | ( ':' ) !| JAVANAME )* )
			dbg.enterAlt(1);

			// C:\\overture\\astCreator-github\\astCreator\\src\\main\\resources\\Astc.g:318:11: ( ID | NormalChar | '+' | '||' | '&&' | ( ':' ) !| JAVANAME )*
			{
			root_0 = (Object)adaptor.nil();


			dbg.location(318,11);
			// C:\\overture\\astCreator-github\\astCreator\\src\\main\\resources\\Astc.g:318:11: ( ID | NormalChar | '+' | '||' | '&&' | ( ':' ) !| JAVANAME )*
			try { dbg.enterSubRule(20);

			loop20:
			while (true) {
				int alt20=8;
				try { dbg.enterDecision(20, decisionCanBacktrack[20]);

				switch ( input.LA(1) ) {
				case ID:
					{
					alt20=1;
					}
					break;
				case NormalChar:
					{
					alt20=2;
					}
					break;
				case 27:
					{
					alt20=3;
					}
					break;
				case 36:
					{
					alt20=4;
					}
					break;
				case 22:
					{
					alt20=5;
					}
					break;
				case COLON:
					{
					alt20=6;
					}
					break;
				case JAVANAME:
					{
					alt20=7;
					}
					break;
				}
				} finally {dbg.exitDecision(20);}

				switch (alt20) {
				case 1 :
					dbg.enterAlt(1);

					// C:\\overture\\astCreator-github\\astCreator\\src\\main\\resources\\Astc.g:318:12: ID
					{
					dbg.location(318,12);
					ID72=(Token)match(input,ID,FOLLOW_ID_in_stringLiteral991); 
					ID72_tree = (Object)adaptor.create(ID72);
					adaptor.addChild(root_0, ID72_tree);

					}
					break;
				case 2 :
					dbg.enterAlt(2);

					// C:\\overture\\astCreator-github\\astCreator\\src\\main\\resources\\Astc.g:318:17: NormalChar
					{
					dbg.location(318,17);
					NormalChar73=(Token)match(input,NormalChar,FOLLOW_NormalChar_in_stringLiteral995); 
					NormalChar73_tree = (Object)adaptor.create(NormalChar73);
					adaptor.addChild(root_0, NormalChar73_tree);

					}
					break;
				case 3 :
					dbg.enterAlt(3);

					// C:\\overture\\astCreator-github\\astCreator\\src\\main\\resources\\Astc.g:318:30: '+'
					{
					dbg.location(318,30);
					char_literal74=(Token)match(input,27,FOLLOW_27_in_stringLiteral999); 
					char_literal74_tree = (Object)adaptor.create(char_literal74);
					adaptor.addChild(root_0, char_literal74_tree);

					}
					break;
				case 4 :
					dbg.enterAlt(4);

					// C:\\overture\\astCreator-github\\astCreator\\src\\main\\resources\\Astc.g:318:34: '||'
					{
					dbg.location(318,34);
					string_literal75=(Token)match(input,36,FOLLOW_36_in_stringLiteral1001); 
					string_literal75_tree = (Object)adaptor.create(string_literal75);
					adaptor.addChild(root_0, string_literal75_tree);

					}
					break;
				case 5 :
					dbg.enterAlt(5);

					// C:\\overture\\astCreator-github\\astCreator\\src\\main\\resources\\Astc.g:318:39: '&&'
					{
					dbg.location(318,39);
					string_literal76=(Token)match(input,22,FOLLOW_22_in_stringLiteral1003); 
					string_literal76_tree = (Object)adaptor.create(string_literal76);
					adaptor.addChild(root_0, string_literal76_tree);

					}
					break;
				case 6 :
					dbg.enterAlt(6);

					// C:\\overture\\astCreator-github\\astCreator\\src\\main\\resources\\Astc.g:318:44: ( ':' ) !
					{
					dbg.location(318,49);
					// C:\\overture\\astCreator-github\\astCreator\\src\\main\\resources\\Astc.g:318:44: ( ':' )
					dbg.enterAlt(1);

					// C:\\overture\\astCreator-github\\astCreator\\src\\main\\resources\\Astc.g:318:45: ':'
					{
					dbg.location(318,45);
					char_literal77=(Token)match(input,COLON,FOLLOW_COLON_in_stringLiteral1006); 
					char_literal77_tree = (Object)adaptor.create(char_literal77);
					adaptor.addChild(root_0, char_literal77_tree);

					}

					}
					break;
				case 7 :
					dbg.enterAlt(7);

					// C:\\overture\\astCreator-github\\astCreator\\src\\main\\resources\\Astc.g:318:52: JAVANAME
					{
					dbg.location(318,52);
					JAVANAME78=(Token)match(input,JAVANAME,FOLLOW_JAVANAME_in_stringLiteral1011); 
					JAVANAME78_tree = (Object)adaptor.create(JAVANAME78);
					adaptor.addChild(root_0, JAVANAME78_tree);

					}
					break;

				default :
					break loop20;
				}
			}
			} finally {dbg.exitSubRule(20);}

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(319, 4);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "stringLiteral");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "stringLiteral"

	// Delegated rules



	public static final BitSet FOLLOW_SUBTYPE_in_extends311 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_ID_in_extends313 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_pkg_in_root443 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_toks_in_root445 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_ast_in_root447 = new BitSet(new long[]{0x0000000000000010L});
	public static final BitSet FOLLOW_aspectdcl_in_root449 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_PACKAGES_in_pkg467 = new BitSet(new long[]{0x0000000300000002L});
	public static final BitSet FOLLOW_33_in_pkg471 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_JAVANAME_in_pkg473 = new BitSet(new long[]{0x0000000010000000L});
	public static final BitSet FOLLOW_28_in_pkg475 = new BitSet(new long[]{0x0000000100000002L});
	public static final BitSet FOLLOW_32_in_pkg482 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_JAVANAME_in_pkg484 = new BitSet(new long[]{0x0000000010000000L});
	public static final BitSet FOLLOW_28_in_pkg486 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_AST_in_ast505 = new BitSet(new long[]{0x0000000000100802L});
	public static final BitSet FOLLOW_production_in_ast510 = new BitSet(new long[]{0x0000000000100802L});
	public static final BitSet FOLLOW_TOKENS_in_toks528 = new BitSet(new long[]{0x0000000000000802L});
	public static final BitSet FOLLOW_token_in_toks533 = new BitSet(new long[]{0x0000000000000802L});
	public static final BitSet FOLLOW_ASPECT_DCL_in_aspectdcl551 = new BitSet(new long[]{0x0000000000200002L});
	public static final BitSet FOLLOW_aspectdcla_in_aspectdcl555 = new BitSet(new long[]{0x0000000010000000L});
	public static final BitSet FOLLOW_28_in_aspectdcl557 = new BitSet(new long[]{0x0000000000200002L});
	public static final BitSet FOLLOW_21_in_aspectdcla575 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_dd_in_aspectdcla578 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_aspectName_in_dd594 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_ASSIGN_in_dd596 = new BitSet(new long[]{0x0000000040801802L});
	public static final BitSet FOLLOW_definitions_in_dd599 = new BitSet(new long[]{0x0000000040801802L});
	public static final BitSet FOLLOW_ID_in_aspectName629 = new BitSet(new long[]{0x0000000000000402L});
	public static final BitSet FOLLOW_FIELD_DCL_in_aspectName633 = new BitSet(new long[]{0x0000000000100800L});
	public static final BitSet FOLLOW_name_in_aspectName635 = new BitSet(new long[]{0x0000000000000402L});
	public static final BitSet FOLLOW_name_in_production651 = new BitSet(new long[]{0x0000000410010020L});
	public static final BitSet FOLLOW_extends_in_production653 = new BitSet(new long[]{0x0000000410000020L});
	public static final BitSet FOLLOW_productionfields_in_production656 = new BitSet(new long[]{0x0000000010000020L});
	public static final BitSet FOLLOW_ASSIGN_in_production660 = new BitSet(new long[]{0x0000000C50901800L});
	public static final BitSet FOLLOW_alternative_in_production662 = new BitSet(new long[]{0x0000000810000000L});
	public static final BitSet FOLLOW_35_in_production665 = new BitSet(new long[]{0x0000000C50901800L});
	public static final BitSet FOLLOW_alternative_in_production667 = new BitSet(new long[]{0x0000000810000000L});
	public static final BitSet FOLLOW_28_in_production673 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_name707 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_20_in_name715 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_ID_in_name717 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_34_in_productionfields742 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_FIELD_DCL_in_productionfields745 = new BitSet(new long[]{0x0000002000000800L});
	public static final BitSet FOLLOW_productionfield_in_productionfields748 = new BitSet(new long[]{0x0000002000000800L});
	public static final BitSet FOLLOW_37_in_productionfields751 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_productionfield767 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_ASSIGN_in_productionfield770 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_QUOTE_in_productionfield773 = new BitSet(new long[]{0x000000100840B880L});
	public static final BitSet FOLLOW_stringLiteral_in_productionfield776 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_QUOTE_in_productionfield778 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_34_in_alternative794 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_ID_in_alternative796 = new BitSet(new long[]{0x0000002000000000L});
	public static final BitSet FOLLOW_37_in_alternative798 = new BitSet(new long[]{0x0000000040801802L});
	public static final BitSet FOLLOW_definitions_in_alternative803 = new BitSet(new long[]{0x0000000040801802L});
	public static final BitSet FOLLOW_20_in_alternative822 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_ID_in_alternative824 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_30_in_definitions850 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_ID_in_definitions852 = new BitSet(new long[]{0x0000000080000000L});
	public static final BitSet FOLLOW_31_in_definitions854 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_COLON_in_definitions857 = new BitSet(new long[]{0x0000000000001800L});
	public static final BitSet FOLLOW_23_in_definitions864 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_ID_in_definitions866 = new BitSet(new long[]{0x0000000001000000L});
	public static final BitSet FOLLOW_24_in_definitions868 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_COLON_in_definitions871 = new BitSet(new long[]{0x0000000000001800L});
	public static final BitSet FOLLOW_set_in_definitions876 = new BitSet(new long[]{0x000000002E000002L});
	public static final BitSet FOLLOW_repeat_in_definitions886 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_token954 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_ASSIGN_in_token957 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_QUOTE_in_token960 = new BitSet(new long[]{0x000000100840B880L});
	public static final BitSet FOLLOW_stringLiteral_in_token963 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_QUOTE_in_token965 = new BitSet(new long[]{0x0000000010000000L});
	public static final BitSet FOLLOW_28_in_token968 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_stringLiteral991 = new BitSet(new long[]{0x0000001008403882L});
	public static final BitSet FOLLOW_NormalChar_in_stringLiteral995 = new BitSet(new long[]{0x0000001008403882L});
	public static final BitSet FOLLOW_27_in_stringLiteral999 = new BitSet(new long[]{0x0000001008403882L});
	public static final BitSet FOLLOW_36_in_stringLiteral1001 = new BitSet(new long[]{0x0000001008403882L});
	public static final BitSet FOLLOW_22_in_stringLiteral1003 = new BitSet(new long[]{0x0000001008403882L});
	public static final BitSet FOLLOW_COLON_in_stringLiteral1006 = new BitSet(new long[]{0x0000001008403882L});
	public static final BitSet FOLLOW_JAVANAME_in_stringLiteral1011 = new BitSet(new long[]{0x0000001008403882L});
}
