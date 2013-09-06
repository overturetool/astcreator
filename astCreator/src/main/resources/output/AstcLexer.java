// $ANTLR 3.5 C:\\overture\\astCreator-github\\astCreator\\src\\main\\resources\\Astc.g 2013-09-06 20:14:17
  
package com.lausdahl.ast.creator.parser;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class AstcLexer extends Lexer {
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

	    @SuppressWarnings({ "unused", "rawtypes" })
	    private Stack myStack = null;
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


	// delegates
	// delegators
	public Lexer[] getDelegates() {
		return new Lexer[] {};
	}

	public AstcLexer() {} 
	public AstcLexer(CharStream input) {
		this(input, new RecognizerSharedState());
	}
	public AstcLexer(CharStream input, RecognizerSharedState state) {
		super(input,state);
	}
	@Override public String getGrammarFileName() { return "C:\\overture\\astCreator-github\\astCreator\\src\\main\\resources\\Astc.g"; }

	// $ANTLR start "ASPECT_DCL"
	public final void mASPECT_DCL() throws RecognitionException {
		try {
			int _type = ASPECT_DCL;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\overture\\astCreator-github\\astCreator\\src\\main\\resources\\Astc.g:94:12: ( 'Aspect Declaration' )
			// C:\\overture\\astCreator-github\\astCreator\\src\\main\\resources\\Astc.g:94:14: 'Aspect Declaration'
			{
			match("Aspect Declaration"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ASPECT_DCL"

	// $ANTLR start "ASSIGN"
	public final void mASSIGN() throws RecognitionException {
		try {
			int _type = ASSIGN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\overture\\astCreator-github\\astCreator\\src\\main\\resources\\Astc.g:95:8: ( '=' )
			// C:\\overture\\astCreator-github\\astCreator\\src\\main\\resources\\Astc.g:95:10: '='
			{
			match('='); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ASSIGN"

	// $ANTLR start "AST"
	public final void mAST() throws RecognitionException {
		try {
			int _type = AST;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\overture\\astCreator-github\\astCreator\\src\\main\\resources\\Astc.g:96:5: ( 'Abstract Syntax Tree' )
			// C:\\overture\\astCreator-github\\astCreator\\src\\main\\resources\\Astc.g:96:7: 'Abstract Syntax Tree'
			{
			match("Abstract Syntax Tree"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "AST"

	// $ANTLR start "COLON"
	public final void mCOLON() throws RecognitionException {
		try {
			int _type = COLON;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\overture\\astCreator-github\\astCreator\\src\\main\\resources\\Astc.g:97:7: ( ':' )
			// C:\\overture\\astCreator-github\\astCreator\\src\\main\\resources\\Astc.g:97:9: ':'
			{
			match(':'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "COLON"

	// $ANTLR start "FIELD_DCL"
	public final void mFIELD_DCL() throws RecognitionException {
		try {
			int _type = FIELD_DCL;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\overture\\astCreator-github\\astCreator\\src\\main\\resources\\Astc.g:98:11: ( '->' )
			// C:\\overture\\astCreator-github\\astCreator\\src\\main\\resources\\Astc.g:98:13: '->'
			{
			match("->"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "FIELD_DCL"

	// $ANTLR start "PACKAGES"
	public final void mPACKAGES() throws RecognitionException {
		try {
			int _type = PACKAGES;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\overture\\astCreator-github\\astCreator\\src\\main\\resources\\Astc.g:99:10: ( 'Packages' )
			// C:\\overture\\astCreator-github\\astCreator\\src\\main\\resources\\Astc.g:99:12: 'Packages'
			{
			match("Packages"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "PACKAGES"

	// $ANTLR start "TOKENS"
	public final void mTOKENS() throws RecognitionException {
		try {
			int _type = TOKENS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\overture\\astCreator-github\\astCreator\\src\\main\\resources\\Astc.g:100:8: ( 'Tokens' )
			// C:\\overture\\astCreator-github\\astCreator\\src\\main\\resources\\Astc.g:100:10: 'Tokens'
			{
			match("Tokens"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "TOKENS"

	// $ANTLR start "T__20"
	public final void mT__20() throws RecognitionException {
		try {
			int _type = T__20;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\overture\\astCreator-github\\astCreator\\src\\main\\resources\\Astc.g:101:7: ( '#' )
			// C:\\overture\\astCreator-github\\astCreator\\src\\main\\resources\\Astc.g:101:9: '#'
			{
			match('#'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__20"

	// $ANTLR start "T__21"
	public final void mT__21() throws RecognitionException {
		try {
			int _type = T__21;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\overture\\astCreator-github\\astCreator\\src\\main\\resources\\Astc.g:102:7: ( '%' )
			// C:\\overture\\astCreator-github\\astCreator\\src\\main\\resources\\Astc.g:102:9: '%'
			{
			match('%'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__21"

	// $ANTLR start "T__22"
	public final void mT__22() throws RecognitionException {
		try {
			int _type = T__22;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\overture\\astCreator-github\\astCreator\\src\\main\\resources\\Astc.g:103:7: ( '&&' )
			// C:\\overture\\astCreator-github\\astCreator\\src\\main\\resources\\Astc.g:103:9: '&&'
			{
			match("&&"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__22"

	// $ANTLR start "T__23"
	public final void mT__23() throws RecognitionException {
		try {
			int _type = T__23;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\overture\\astCreator-github\\astCreator\\src\\main\\resources\\Astc.g:104:7: ( '(' )
			// C:\\overture\\astCreator-github\\astCreator\\src\\main\\resources\\Astc.g:104:9: '('
			{
			match('('); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__23"

	// $ANTLR start "T__24"
	public final void mT__24() throws RecognitionException {
		try {
			int _type = T__24;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\overture\\astCreator-github\\astCreator\\src\\main\\resources\\Astc.g:105:7: ( ')' )
			// C:\\overture\\astCreator-github\\astCreator\\src\\main\\resources\\Astc.g:105:9: ')'
			{
			match(')'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__24"

	// $ANTLR start "T__25"
	public final void mT__25() throws RecognitionException {
		try {
			int _type = T__25;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\overture\\astCreator-github\\astCreator\\src\\main\\resources\\Astc.g:106:7: ( '*' )
			// C:\\overture\\astCreator-github\\astCreator\\src\\main\\resources\\Astc.g:106:9: '*'
			{
			match('*'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__25"

	// $ANTLR start "T__26"
	public final void mT__26() throws RecognitionException {
		try {
			int _type = T__26;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\overture\\astCreator-github\\astCreator\\src\\main\\resources\\Astc.g:107:7: ( '**' )
			// C:\\overture\\astCreator-github\\astCreator\\src\\main\\resources\\Astc.g:107:9: '**'
			{
			match("**"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__26"

	// $ANTLR start "T__27"
	public final void mT__27() throws RecognitionException {
		try {
			int _type = T__27;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\overture\\astCreator-github\\astCreator\\src\\main\\resources\\Astc.g:108:7: ( '+' )
			// C:\\overture\\astCreator-github\\astCreator\\src\\main\\resources\\Astc.g:108:9: '+'
			{
			match('+'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__27"

	// $ANTLR start "T__28"
	public final void mT__28() throws RecognitionException {
		try {
			int _type = T__28;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\overture\\astCreator-github\\astCreator\\src\\main\\resources\\Astc.g:109:7: ( ';' )
			// C:\\overture\\astCreator-github\\astCreator\\src\\main\\resources\\Astc.g:109:9: ';'
			{
			match(';'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__28"

	// $ANTLR start "T__29"
	public final void mT__29() throws RecognitionException {
		try {
			int _type = T__29;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\overture\\astCreator-github\\astCreator\\src\\main\\resources\\Astc.g:110:7: ( '?' )
			// C:\\overture\\astCreator-github\\astCreator\\src\\main\\resources\\Astc.g:110:9: '?'
			{
			match('?'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__29"

	// $ANTLR start "T__30"
	public final void mT__30() throws RecognitionException {
		try {
			int _type = T__30;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\overture\\astCreator-github\\astCreator\\src\\main\\resources\\Astc.g:111:7: ( '[' )
			// C:\\overture\\astCreator-github\\astCreator\\src\\main\\resources\\Astc.g:111:9: '['
			{
			match('['); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__30"

	// $ANTLR start "T__31"
	public final void mT__31() throws RecognitionException {
		try {
			int _type = T__31;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\overture\\astCreator-github\\astCreator\\src\\main\\resources\\Astc.g:112:7: ( ']' )
			// C:\\overture\\astCreator-github\\astCreator\\src\\main\\resources\\Astc.g:112:9: ']'
			{
			match(']'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__31"

	// $ANTLR start "T__32"
	public final void mT__32() throws RecognitionException {
		try {
			int _type = T__32;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\overture\\astCreator-github\\astCreator\\src\\main\\resources\\Astc.g:113:7: ( 'analysis' )
			// C:\\overture\\astCreator-github\\astCreator\\src\\main\\resources\\Astc.g:113:9: 'analysis'
			{
			match("analysis"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__32"

	// $ANTLR start "T__33"
	public final void mT__33() throws RecognitionException {
		try {
			int _type = T__33;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\overture\\astCreator-github\\astCreator\\src\\main\\resources\\Astc.g:114:7: ( 'base' )
			// C:\\overture\\astCreator-github\\astCreator\\src\\main\\resources\\Astc.g:114:9: 'base'
			{
			match("base"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__33"

	// $ANTLR start "T__34"
	public final void mT__34() throws RecognitionException {
		try {
			int _type = T__34;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\overture\\astCreator-github\\astCreator\\src\\main\\resources\\Astc.g:115:7: ( '{' )
			// C:\\overture\\astCreator-github\\astCreator\\src\\main\\resources\\Astc.g:115:9: '{'
			{
			match('{'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__34"

	// $ANTLR start "T__35"
	public final void mT__35() throws RecognitionException {
		try {
			int _type = T__35;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\overture\\astCreator-github\\astCreator\\src\\main\\resources\\Astc.g:116:7: ( '|' )
			// C:\\overture\\astCreator-github\\astCreator\\src\\main\\resources\\Astc.g:116:9: '|'
			{
			match('|'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__35"

	// $ANTLR start "T__36"
	public final void mT__36() throws RecognitionException {
		try {
			int _type = T__36;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\overture\\astCreator-github\\astCreator\\src\\main\\resources\\Astc.g:117:7: ( '||' )
			// C:\\overture\\astCreator-github\\astCreator\\src\\main\\resources\\Astc.g:117:9: '||'
			{
			match("||"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__36"

	// $ANTLR start "T__37"
	public final void mT__37() throws RecognitionException {
		try {
			int _type = T__37;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\overture\\astCreator-github\\astCreator\\src\\main\\resources\\Astc.g:118:7: ( '}' )
			// C:\\overture\\astCreator-github\\astCreator\\src\\main\\resources\\Astc.g:118:9: '}'
			{
			match('}'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__37"

	// $ANTLR start "QUOTE"
	public final void mQUOTE() throws RecognitionException {
		try {
			int _type = QUOTE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\overture\\astCreator-github\\astCreator\\src\\main\\resources\\Astc.g:192:9: ( '\\'' )
			// C:\\overture\\astCreator-github\\astCreator\\src\\main\\resources\\Astc.g:192:16: '\\''
			{
			match('\''); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "QUOTE"

	// $ANTLR start "COMMENT"
	public final void mCOMMENT() throws RecognitionException {
		try {
			int _type = COMMENT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\overture\\astCreator-github\\astCreator\\src\\main\\resources\\Astc.g:195:5: ( '--' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? ( '\\n' )? | '//' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? ( '\\n' )? | '/*' ( options {greedy=false; } : . )* '*/' )
			int alt8=3;
			int LA8_0 = input.LA(1);
			if ( (LA8_0=='-') ) {
				alt8=1;
			}
			else if ( (LA8_0=='/') ) {
				int LA8_2 = input.LA(2);
				if ( (LA8_2=='/') ) {
					alt8=2;
				}
				else if ( (LA8_2=='*') ) {
					alt8=3;
				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 8, 2, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 8, 0, input);
				throw nvae;
			}

			switch (alt8) {
				case 1 :
					// C:\\overture\\astCreator-github\\astCreator\\src\\main\\resources\\Astc.g:195:9: '--' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? ( '\\n' )?
					{
					match("--"); 

					// C:\\overture\\astCreator-github\\astCreator\\src\\main\\resources\\Astc.g:195:14: (~ ( '\\n' | '\\r' ) )*
					loop1:
					while (true) {
						int alt1=2;
						int LA1_0 = input.LA(1);
						if ( ((LA1_0 >= '\u0000' && LA1_0 <= '\t')||(LA1_0 >= '\u000B' && LA1_0 <= '\f')||(LA1_0 >= '\u000E' && LA1_0 <= '\uFFFF')) ) {
							alt1=1;
						}

						switch (alt1) {
						case 1 :
							// C:\\overture\\astCreator-github\\astCreator\\src\\main\\resources\\Astc.g:
							{
							if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '\t')||(input.LA(1) >= '\u000B' && input.LA(1) <= '\f')||(input.LA(1) >= '\u000E' && input.LA(1) <= '\uFFFF') ) {
								input.consume();
							}
							else {
								MismatchedSetException mse = new MismatchedSetException(null,input);
								recover(mse);
								throw mse;
							}
							}
							break;

						default :
							break loop1;
						}
					}

					// C:\\overture\\astCreator-github\\astCreator\\src\\main\\resources\\Astc.g:195:28: ( '\\r' )?
					int alt2=2;
					int LA2_0 = input.LA(1);
					if ( (LA2_0=='\r') ) {
						alt2=1;
					}
					switch (alt2) {
						case 1 :
							// C:\\overture\\astCreator-github\\astCreator\\src\\main\\resources\\Astc.g:195:28: '\\r'
							{
							match('\r'); 
							}
							break;

					}

					// C:\\overture\\astCreator-github\\astCreator\\src\\main\\resources\\Astc.g:195:34: ( '\\n' )?
					int alt3=2;
					int LA3_0 = input.LA(1);
					if ( (LA3_0=='\n') ) {
						alt3=1;
					}
					switch (alt3) {
						case 1 :
							// C:\\overture\\astCreator-github\\astCreator\\src\\main\\resources\\Astc.g:195:34: '\\n'
							{
							match('\n'); 
							}
							break;

					}

					_channel=HIDDEN;
					}
					break;
				case 2 :
					// C:\\overture\\astCreator-github\\astCreator\\src\\main\\resources\\Astc.g:196:9: '//' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? ( '\\n' )?
					{
					match("//"); 

					// C:\\overture\\astCreator-github\\astCreator\\src\\main\\resources\\Astc.g:196:14: (~ ( '\\n' | '\\r' ) )*
					loop4:
					while (true) {
						int alt4=2;
						int LA4_0 = input.LA(1);
						if ( ((LA4_0 >= '\u0000' && LA4_0 <= '\t')||(LA4_0 >= '\u000B' && LA4_0 <= '\f')||(LA4_0 >= '\u000E' && LA4_0 <= '\uFFFF')) ) {
							alt4=1;
						}

						switch (alt4) {
						case 1 :
							// C:\\overture\\astCreator-github\\astCreator\\src\\main\\resources\\Astc.g:
							{
							if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '\t')||(input.LA(1) >= '\u000B' && input.LA(1) <= '\f')||(input.LA(1) >= '\u000E' && input.LA(1) <= '\uFFFF') ) {
								input.consume();
							}
							else {
								MismatchedSetException mse = new MismatchedSetException(null,input);
								recover(mse);
								throw mse;
							}
							}
							break;

						default :
							break loop4;
						}
					}

					// C:\\overture\\astCreator-github\\astCreator\\src\\main\\resources\\Astc.g:196:28: ( '\\r' )?
					int alt5=2;
					int LA5_0 = input.LA(1);
					if ( (LA5_0=='\r') ) {
						alt5=1;
					}
					switch (alt5) {
						case 1 :
							// C:\\overture\\astCreator-github\\astCreator\\src\\main\\resources\\Astc.g:196:28: '\\r'
							{
							match('\r'); 
							}
							break;

					}

					// C:\\overture\\astCreator-github\\astCreator\\src\\main\\resources\\Astc.g:196:34: ( '\\n' )?
					int alt6=2;
					int LA6_0 = input.LA(1);
					if ( (LA6_0=='\n') ) {
						alt6=1;
					}
					switch (alt6) {
						case 1 :
							// C:\\overture\\astCreator-github\\astCreator\\src\\main\\resources\\Astc.g:196:34: '\\n'
							{
							match('\n'); 
							}
							break;

					}

					_channel=HIDDEN;
					}
					break;
				case 3 :
					// C:\\overture\\astCreator-github\\astCreator\\src\\main\\resources\\Astc.g:197:9: '/*' ( options {greedy=false; } : . )* '*/'
					{
					match("/*"); 

					// C:\\overture\\astCreator-github\\astCreator\\src\\main\\resources\\Astc.g:197:14: ( options {greedy=false; } : . )*
					loop7:
					while (true) {
						int alt7=2;
						int LA7_0 = input.LA(1);
						if ( (LA7_0=='*') ) {
							int LA7_1 = input.LA(2);
							if ( (LA7_1=='/') ) {
								alt7=2;
							}
							else if ( ((LA7_1 >= '\u0000' && LA7_1 <= '.')||(LA7_1 >= '0' && LA7_1 <= '\uFFFF')) ) {
								alt7=1;
							}

						}
						else if ( ((LA7_0 >= '\u0000' && LA7_0 <= ')')||(LA7_0 >= '+' && LA7_0 <= '\uFFFF')) ) {
							alt7=1;
						}

						switch (alt7) {
						case 1 :
							// C:\\overture\\astCreator-github\\astCreator\\src\\main\\resources\\Astc.g:197:42: .
							{
							matchAny(); 
							}
							break;

						default :
							break loop7;
						}
					}

					match("*/"); 

					_channel=HIDDEN;
					}
					break;

			}
			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "COMMENT"

	// $ANTLR start "ID"
	public final void mID() throws RecognitionException {
		try {
			int _type = ID;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\overture\\astCreator-github\\astCreator\\src\\main\\resources\\Astc.g:200:5: ( ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )* )
			// C:\\overture\\astCreator-github\\astCreator\\src\\main\\resources\\Astc.g:200:7: ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
			{
			if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			// C:\\overture\\astCreator-github\\astCreator\\src\\main\\resources\\Astc.g:200:31: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
			loop9:
			while (true) {
				int alt9=2;
				int LA9_0 = input.LA(1);
				if ( ((LA9_0 >= '0' && LA9_0 <= '9')||(LA9_0 >= 'A' && LA9_0 <= 'Z')||LA9_0=='_'||(LA9_0 >= 'a' && LA9_0 <= 'z')) ) {
					alt9=1;
				}

				switch (alt9) {
				case 1 :
					// C:\\overture\\astCreator-github\\astCreator\\src\\main\\resources\\Astc.g:
					{
					if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					break loop9;
				}
			}

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ID"

	// $ANTLR start "JAVANAME"
	public final void mJAVANAME() throws RecognitionException {
		try {
			int _type = JAVANAME;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\overture\\astCreator-github\\astCreator\\src\\main\\resources\\Astc.g:204:3: ( ID ( '.' ( '#' )? ID )* )
			// C:\\overture\\astCreator-github\\astCreator\\src\\main\\resources\\Astc.g:204:5: ID ( '.' ( '#' )? ID )*
			{
			mID(); 

			// C:\\overture\\astCreator-github\\astCreator\\src\\main\\resources\\Astc.g:204:8: ( '.' ( '#' )? ID )*
			loop11:
			while (true) {
				int alt11=2;
				int LA11_0 = input.LA(1);
				if ( (LA11_0=='.') ) {
					alt11=1;
				}

				switch (alt11) {
				case 1 :
					// C:\\overture\\astCreator-github\\astCreator\\src\\main\\resources\\Astc.g:204:9: '.' ( '#' )? ID
					{
					match('.'); 
					// C:\\overture\\astCreator-github\\astCreator\\src\\main\\resources\\Astc.g:204:13: ( '#' )?
					int alt10=2;
					int LA10_0 = input.LA(1);
					if ( (LA10_0=='#') ) {
						alt10=1;
					}
					switch (alt10) {
						case 1 :
							// C:\\overture\\astCreator-github\\astCreator\\src\\main\\resources\\Astc.g:204:13: '#'
							{
							match('#'); 
							}
							break;

					}

					mID(); 

					}
					break;

				default :
					break loop11;
				}
			}

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "JAVANAME"

	// $ANTLR start "SUBTYPE"
	public final void mSUBTYPE() throws RecognitionException {
		try {
			int _type = SUBTYPE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\overture\\astCreator-github\\astCreator\\src\\main\\resources\\Astc.g:208:5: ( '<:' )
			// C:\\overture\\astCreator-github\\astCreator\\src\\main\\resources\\Astc.g:208:7: '<:'
			{
			match("<:"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "SUBTYPE"

	// $ANTLR start "WS"
	public final void mWS() throws RecognitionException {
		try {
			int _type = WS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\overture\\astCreator-github\\astCreator\\src\\main\\resources\\Astc.g:220:5: ( ( ' ' | '\\t' | '\\r' | '\\n' ) )
			// C:\\overture\\astCreator-github\\astCreator\\src\\main\\resources\\Astc.g:220:9: ( ' ' | '\\t' | '\\r' | '\\n' )
			{
			if ( (input.LA(1) >= '\t' && input.LA(1) <= '\n')||input.LA(1)=='\r'||input.LA(1)==' ' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			_channel=HIDDEN;
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "WS"

	// $ANTLR start "ESC_SEQ"
	public final void mESC_SEQ() throws RecognitionException {
		try {
			// C:\\overture\\astCreator-github\\astCreator\\src\\main\\resources\\Astc.g:230:5: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\\\' ) )
			// C:\\overture\\astCreator-github\\astCreator\\src\\main\\resources\\Astc.g:230:9: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\\\' )
			{
			match('\\'); 
			if ( input.LA(1)=='\"'||input.LA(1)=='\\'||input.LA(1)=='b'||input.LA(1)=='f'||input.LA(1)=='n'||input.LA(1)=='r'||input.LA(1)=='t' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ESC_SEQ"

	// $ANTLR start "SpecialChar"
	public final void mSpecialChar() throws RecognitionException {
		try {
			int _type = SpecialChar;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\overture\\astCreator-github\\astCreator\\src\\main\\resources\\Astc.g:322:5: ( '\"' | '\\\\' | '$' )
			// C:\\overture\\astCreator-github\\astCreator\\src\\main\\resources\\Astc.g:
			{
			if ( input.LA(1)=='\"'||input.LA(1)=='$'||input.LA(1)=='\\' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "SpecialChar"

	// $ANTLR start "NormalChar"
	public final void mNormalChar() throws RecognitionException {
		try {
			int _type = NormalChar;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\overture\\astCreator-github\\astCreator\\src\\main\\resources\\Astc.g:325:5: (~ SpecialChar )
			// C:\\overture\\astCreator-github\\astCreator\\src\\main\\resources\\Astc.g:
			{
			if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '!')||input.LA(1)=='#'||(input.LA(1) >= '%' && input.LA(1) <= '[')||(input.LA(1) >= ']' && input.LA(1) <= '\uFFFF') ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "NormalChar"

	@Override
	public void mTokens() throws RecognitionException {
		// C:\\overture\\astCreator-github\\astCreator\\src\\main\\resources\\Astc.g:1:8: ( ASPECT_DCL | ASSIGN | AST | COLON | FIELD_DCL | PACKAGES | TOKENS | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | QUOTE | COMMENT | ID | JAVANAME | SUBTYPE | WS | SpecialChar | NormalChar )
		int alt12=33;
		alt12 = dfa12.predict(input);
		switch (alt12) {
			case 1 :
				// C:\\overture\\astCreator-github\\astCreator\\src\\main\\resources\\Astc.g:1:10: ASPECT_DCL
				{
				mASPECT_DCL(); 

				}
				break;
			case 2 :
				// C:\\overture\\astCreator-github\\astCreator\\src\\main\\resources\\Astc.g:1:21: ASSIGN
				{
				mASSIGN(); 

				}
				break;
			case 3 :
				// C:\\overture\\astCreator-github\\astCreator\\src\\main\\resources\\Astc.g:1:28: AST
				{
				mAST(); 

				}
				break;
			case 4 :
				// C:\\overture\\astCreator-github\\astCreator\\src\\main\\resources\\Astc.g:1:32: COLON
				{
				mCOLON(); 

				}
				break;
			case 5 :
				// C:\\overture\\astCreator-github\\astCreator\\src\\main\\resources\\Astc.g:1:38: FIELD_DCL
				{
				mFIELD_DCL(); 

				}
				break;
			case 6 :
				// C:\\overture\\astCreator-github\\astCreator\\src\\main\\resources\\Astc.g:1:48: PACKAGES
				{
				mPACKAGES(); 

				}
				break;
			case 7 :
				// C:\\overture\\astCreator-github\\astCreator\\src\\main\\resources\\Astc.g:1:57: TOKENS
				{
				mTOKENS(); 

				}
				break;
			case 8 :
				// C:\\overture\\astCreator-github\\astCreator\\src\\main\\resources\\Astc.g:1:64: T__20
				{
				mT__20(); 

				}
				break;
			case 9 :
				// C:\\overture\\astCreator-github\\astCreator\\src\\main\\resources\\Astc.g:1:70: T__21
				{
				mT__21(); 

				}
				break;
			case 10 :
				// C:\\overture\\astCreator-github\\astCreator\\src\\main\\resources\\Astc.g:1:76: T__22
				{
				mT__22(); 

				}
				break;
			case 11 :
				// C:\\overture\\astCreator-github\\astCreator\\src\\main\\resources\\Astc.g:1:82: T__23
				{
				mT__23(); 

				}
				break;
			case 12 :
				// C:\\overture\\astCreator-github\\astCreator\\src\\main\\resources\\Astc.g:1:88: T__24
				{
				mT__24(); 

				}
				break;
			case 13 :
				// C:\\overture\\astCreator-github\\astCreator\\src\\main\\resources\\Astc.g:1:94: T__25
				{
				mT__25(); 

				}
				break;
			case 14 :
				// C:\\overture\\astCreator-github\\astCreator\\src\\main\\resources\\Astc.g:1:100: T__26
				{
				mT__26(); 

				}
				break;
			case 15 :
				// C:\\overture\\astCreator-github\\astCreator\\src\\main\\resources\\Astc.g:1:106: T__27
				{
				mT__27(); 

				}
				break;
			case 16 :
				// C:\\overture\\astCreator-github\\astCreator\\src\\main\\resources\\Astc.g:1:112: T__28
				{
				mT__28(); 

				}
				break;
			case 17 :
				// C:\\overture\\astCreator-github\\astCreator\\src\\main\\resources\\Astc.g:1:118: T__29
				{
				mT__29(); 

				}
				break;
			case 18 :
				// C:\\overture\\astCreator-github\\astCreator\\src\\main\\resources\\Astc.g:1:124: T__30
				{
				mT__30(); 

				}
				break;
			case 19 :
				// C:\\overture\\astCreator-github\\astCreator\\src\\main\\resources\\Astc.g:1:130: T__31
				{
				mT__31(); 

				}
				break;
			case 20 :
				// C:\\overture\\astCreator-github\\astCreator\\src\\main\\resources\\Astc.g:1:136: T__32
				{
				mT__32(); 

				}
				break;
			case 21 :
				// C:\\overture\\astCreator-github\\astCreator\\src\\main\\resources\\Astc.g:1:142: T__33
				{
				mT__33(); 

				}
				break;
			case 22 :
				// C:\\overture\\astCreator-github\\astCreator\\src\\main\\resources\\Astc.g:1:148: T__34
				{
				mT__34(); 

				}
				break;
			case 23 :
				// C:\\overture\\astCreator-github\\astCreator\\src\\main\\resources\\Astc.g:1:154: T__35
				{
				mT__35(); 

				}
				break;
			case 24 :
				// C:\\overture\\astCreator-github\\astCreator\\src\\main\\resources\\Astc.g:1:160: T__36
				{
				mT__36(); 

				}
				break;
			case 25 :
				// C:\\overture\\astCreator-github\\astCreator\\src\\main\\resources\\Astc.g:1:166: T__37
				{
				mT__37(); 

				}
				break;
			case 26 :
				// C:\\overture\\astCreator-github\\astCreator\\src\\main\\resources\\Astc.g:1:172: QUOTE
				{
				mQUOTE(); 

				}
				break;
			case 27 :
				// C:\\overture\\astCreator-github\\astCreator\\src\\main\\resources\\Astc.g:1:178: COMMENT
				{
				mCOMMENT(); 

				}
				break;
			case 28 :
				// C:\\overture\\astCreator-github\\astCreator\\src\\main\\resources\\Astc.g:1:186: ID
				{
				mID(); 

				}
				break;
			case 29 :
				// C:\\overture\\astCreator-github\\astCreator\\src\\main\\resources\\Astc.g:1:189: JAVANAME
				{
				mJAVANAME(); 

				}
				break;
			case 30 :
				// C:\\overture\\astCreator-github\\astCreator\\src\\main\\resources\\Astc.g:1:198: SUBTYPE
				{
				mSUBTYPE(); 

				}
				break;
			case 31 :
				// C:\\overture\\astCreator-github\\astCreator\\src\\main\\resources\\Astc.g:1:206: WS
				{
				mWS(); 

				}
				break;
			case 32 :
				// C:\\overture\\astCreator-github\\astCreator\\src\\main\\resources\\Astc.g:1:209: SpecialChar
				{
				mSpecialChar(); 

				}
				break;
			case 33 :
				// C:\\overture\\astCreator-github\\astCreator\\src\\main\\resources\\Astc.g:1:221: NormalChar
				{
				mNormalChar(); 

				}
				break;

		}
	}


	protected DFA12 dfa12 = new DFA12(this);
	static final String DFA12_eotS =
		"\1\uffff\1\41\2\uffff\1\35\2\41\2\uffff\1\35\2\uffff\1\57\5\uffff\2\41"+
		"\1\uffff\1\71\2\uffff\1\35\1\41\1\35\3\uffff\3\41\6\uffff\2\41\14\uffff"+
		"\2\41\7\uffff\13\41\1\117\5\41\1\uffff\3\41\1\130\1\41\1\uffff\2\41\1"+
		"\uffff\2\41\1\136\1\137\3\uffff";
	static final String DFA12_eofS =
		"\140\uffff";
	static final String DFA12_minS =
		"\1\0\1\56\2\uffff\1\55\2\56\2\uffff\1\46\2\uffff\1\52\5\uffff\2\56\1\uffff"+
		"\1\174\2\uffff\1\52\1\56\1\72\3\uffff\3\56\6\uffff\2\56\14\uffff\2\56"+
		"\7\uffff\21\56\1\uffff\1\40\4\56\1\uffff\2\56\1\uffff\1\56\1\40\2\56\3"+
		"\uffff";
	static final String DFA12_maxS =
		"\1\uffff\1\172\2\uffff\1\76\2\172\2\uffff\1\46\2\uffff\1\52\5\uffff\2"+
		"\172\1\uffff\1\174\2\uffff\1\57\1\172\1\72\3\uffff\3\172\6\uffff\2\172"+
		"\14\uffff\2\172\7\uffff\21\172\1\uffff\5\172\1\uffff\2\172\1\uffff\4\172"+
		"\3\uffff";
	static final String DFA12_acceptS =
		"\2\uffff\1\2\1\4\3\uffff\1\10\1\11\1\uffff\1\13\1\14\1\uffff\1\17\1\20"+
		"\1\21\1\22\1\23\2\uffff\1\26\1\uffff\1\31\1\32\3\uffff\1\37\1\40\1\41"+
		"\3\uffff\1\34\1\35\1\2\1\4\1\5\1\33\2\uffff\1\10\1\11\1\12\1\13\1\14\1"+
		"\16\1\15\1\17\1\20\1\21\1\22\1\23\2\uffff\1\26\1\30\1\27\1\31\1\32\1\36"+
		"\1\37\21\uffff\1\25\5\uffff\1\1\2\uffff\1\7\4\uffff\1\3\1\6\1\24";
	static final String DFA12_specialS =
		"\1\0\137\uffff}>";
	static final String[] DFA12_transitionS = {
			"\11\35\2\33\2\35\1\33\22\35\1\33\1\35\1\34\1\7\1\34\1\10\1\11\1\27\1"+
			"\12\1\13\1\14\1\15\1\35\1\4\1\35\1\30\12\35\1\3\1\16\1\32\1\2\1\35\1"+
			"\17\1\35\1\1\16\31\1\5\3\31\1\6\6\31\1\20\1\34\1\21\1\35\1\31\1\35\1"+
			"\22\1\23\30\31\1\24\1\25\1\26\uff82\35",
			"\1\42\1\uffff\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\1\40\1\37\20"+
			"\40\1\36\7\40",
			"",
			"",
			"\1\46\20\uffff\1\45",
			"\1\42\1\uffff\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\1\47\31\40",
			"\1\42\1\uffff\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\16\40\1\50\13"+
			"\40",
			"",
			"",
			"\1\53",
			"",
			"",
			"\1\56",
			"",
			"",
			"",
			"",
			"",
			"\1\42\1\uffff\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\15\40\1\65\14"+
			"\40",
			"\1\42\1\uffff\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\1\66\31\40",
			"",
			"\1\70",
			"",
			"",
			"\1\46\4\uffff\1\46",
			"\1\42\1\uffff\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\32\40",
			"\1\74",
			"",
			"",
			"",
			"\1\42\1\uffff\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\17\40\1\76\12"+
			"\40",
			"\1\42\1\uffff\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\22\40\1\77\7"+
			"\40",
			"\1\42\1\uffff\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\32\40",
			"",
			"",
			"",
			"",
			"",
			"",
			"\1\42\1\uffff\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\2\40\1\100\27"+
			"\40",
			"\1\42\1\uffff\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\12\40\1\101\17"+
			"\40",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"\1\42\1\uffff\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\1\102\31\40",
			"\1\42\1\uffff\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\22\40\1\103\7"+
			"\40",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"\1\42\1\uffff\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\4\40\1\104\25"+
			"\40",
			"\1\42\1\uffff\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\23\40\1\105\6"+
			"\40",
			"\1\42\1\uffff\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\12\40\1\106\17"+
			"\40",
			"\1\42\1\uffff\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\4\40\1\107\25"+
			"\40",
			"\1\42\1\uffff\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\13\40\1\110\16"+
			"\40",
			"\1\42\1\uffff\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\4\40\1\111\25"+
			"\40",
			"\1\42\1\uffff\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\2\40\1\112\27"+
			"\40",
			"\1\42\1\uffff\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\21\40\1\113\10"+
			"\40",
			"\1\42\1\uffff\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\1\114\31\40",
			"\1\42\1\uffff\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\15\40\1\115\14"+
			"\40",
			"\1\42\1\uffff\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\30\40\1\116\1"+
			"\40",
			"\1\42\1\uffff\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\32\40",
			"\1\42\1\uffff\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\23\40\1\120\6"+
			"\40",
			"\1\42\1\uffff\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\1\121\31\40",
			"\1\42\1\uffff\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\6\40\1\122\23"+
			"\40",
			"\1\42\1\uffff\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\22\40\1\123\7"+
			"\40",
			"\1\42\1\uffff\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\22\40\1\124\7"+
			"\40",
			"",
			"\1\125\15\uffff\1\42\1\uffff\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff"+
			"\32\40",
			"\1\42\1\uffff\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\2\40\1\126\27"+
			"\40",
			"\1\42\1\uffff\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\4\40\1\127\25"+
			"\40",
			"\1\42\1\uffff\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\32\40",
			"\1\42\1\uffff\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\10\40\1\131\21"+
			"\40",
			"",
			"\1\42\1\uffff\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\23\40\1\132\6"+
			"\40",
			"\1\42\1\uffff\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\22\40\1\133\7"+
			"\40",
			"",
			"\1\42\1\uffff\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\22\40\1\134\7"+
			"\40",
			"\1\135\15\uffff\1\42\1\uffff\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff"+
			"\32\40",
			"\1\42\1\uffff\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\32\40",
			"\1\42\1\uffff\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\32\40",
			"",
			"",
			""
	};

	static final short[] DFA12_eot = DFA.unpackEncodedString(DFA12_eotS);
	static final short[] DFA12_eof = DFA.unpackEncodedString(DFA12_eofS);
	static final char[] DFA12_min = DFA.unpackEncodedStringToUnsignedChars(DFA12_minS);
	static final char[] DFA12_max = DFA.unpackEncodedStringToUnsignedChars(DFA12_maxS);
	static final short[] DFA12_accept = DFA.unpackEncodedString(DFA12_acceptS);
	static final short[] DFA12_special = DFA.unpackEncodedString(DFA12_specialS);
	static final short[][] DFA12_transition;

	static {
		int numStates = DFA12_transitionS.length;
		DFA12_transition = new short[numStates][];
		for (int i=0; i<numStates; i++) {
			DFA12_transition[i] = DFA.unpackEncodedString(DFA12_transitionS[i]);
		}
	}

	protected class DFA12 extends DFA {

		public DFA12(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 12;
			this.eot = DFA12_eot;
			this.eof = DFA12_eof;
			this.min = DFA12_min;
			this.max = DFA12_max;
			this.accept = DFA12_accept;
			this.special = DFA12_special;
			this.transition = DFA12_transition;
		}
		@Override
		public String getDescription() {
			return "1:1: Tokens : ( ASPECT_DCL | ASSIGN | AST | COLON | FIELD_DCL | PACKAGES | TOKENS | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | QUOTE | COMMENT | ID | JAVANAME | SUBTYPE | WS | SpecialChar | NormalChar );";
		}
		@Override
		public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
			IntStream input = _input;
			int _s = s;
			switch ( s ) {
					case 0 : 
						int LA12_0 = input.LA(1);
						s = -1;
						if ( (LA12_0=='A') ) {s = 1;}
						else if ( (LA12_0=='=') ) {s = 2;}
						else if ( (LA12_0==':') ) {s = 3;}
						else if ( (LA12_0=='-') ) {s = 4;}
						else if ( (LA12_0=='P') ) {s = 5;}
						else if ( (LA12_0=='T') ) {s = 6;}
						else if ( (LA12_0=='#') ) {s = 7;}
						else if ( (LA12_0=='%') ) {s = 8;}
						else if ( (LA12_0=='&') ) {s = 9;}
						else if ( (LA12_0=='(') ) {s = 10;}
						else if ( (LA12_0==')') ) {s = 11;}
						else if ( (LA12_0=='*') ) {s = 12;}
						else if ( (LA12_0=='+') ) {s = 13;}
						else if ( (LA12_0==';') ) {s = 14;}
						else if ( (LA12_0=='?') ) {s = 15;}
						else if ( (LA12_0=='[') ) {s = 16;}
						else if ( (LA12_0==']') ) {s = 17;}
						else if ( (LA12_0=='a') ) {s = 18;}
						else if ( (LA12_0=='b') ) {s = 19;}
						else if ( (LA12_0=='{') ) {s = 20;}
						else if ( (LA12_0=='|') ) {s = 21;}
						else if ( (LA12_0=='}') ) {s = 22;}
						else if ( (LA12_0=='\'') ) {s = 23;}
						else if ( (LA12_0=='/') ) {s = 24;}
						else if ( ((LA12_0 >= 'B' && LA12_0 <= 'O')||(LA12_0 >= 'Q' && LA12_0 <= 'S')||(LA12_0 >= 'U' && LA12_0 <= 'Z')||LA12_0=='_'||(LA12_0 >= 'c' && LA12_0 <= 'z')) ) {s = 25;}
						else if ( (LA12_0=='<') ) {s = 26;}
						else if ( ((LA12_0 >= '\t' && LA12_0 <= '\n')||LA12_0=='\r'||LA12_0==' ') ) {s = 27;}
						else if ( (LA12_0=='\"'||LA12_0=='$'||LA12_0=='\\') ) {s = 28;}
						else if ( ((LA12_0 >= '\u0000' && LA12_0 <= '\b')||(LA12_0 >= '\u000B' && LA12_0 <= '\f')||(LA12_0 >= '\u000E' && LA12_0 <= '\u001F')||LA12_0=='!'||LA12_0==','||LA12_0=='.'||(LA12_0 >= '0' && LA12_0 <= '9')||LA12_0=='>'||LA12_0=='@'||LA12_0=='^'||LA12_0=='`'||(LA12_0 >= '~' && LA12_0 <= '\uFFFF')) ) {s = 29;}
						if ( s>=0 ) return s;
						break;
			}
			NoViableAltException nvae =
				new NoViableAltException(getDescription(), 12, _s, input);
			error(nvae);
			throw nvae;
		}
	}

}
