package index.app.android;


import android.app.Activity;
import android.os.Bundle;

import java.io.RandomAccessFile;
import 	java.io.RandomAccessFile;
import java.io.*;
import java.io.InputStream;
import java.io.FileInputStream;
import java.lang.Object;
import java.lang.Throwable;
import java.lang.Exception;
import 	java.nio.charset.Charset;
import android.app.Activity; 
import android.view.View; 
import android.view.View.OnClickListener; 
import android.widget.Button; 
import android.widget.EditText; 
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import android.os.Environment;
import android.util.Log;
import android.widget.TextView;
import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;

import java.lang.Object;
import java.lang.Throwable;
import java.lang.Exception;
import java.io.IOException;
import java.io.Reader;
import java.io.BufferedReader;
import java.io.Reader;
import java.io.InputStreamReader;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity
{
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		try
		{
			File f=new File("/sdcard/uindex");
			f.mkdirs();

		}
		catch (Exception e)
		{




			setTitle(e.toString());

		}


		final Button B = (Button)findViewById(R.id.button1); 

		final EditText ED = (EditText)findViewById(R.id.text1);

		final TextView TV = (TextView)findViewById(R.id.tv1);

		B.setOnClickListener(new OnClickListener(){ 
				@Override 
				public void onClick(View arg0)
				{ 
					String s="",ss="";

					String TextEntered = ED.getText().toString(); 
					FileInputStream is;
					BufferedReader reader;

					String [] gg=TextEntered.split("\\.");
					byte[] buffer = new byte[1024];
					byte[] program=new byte[10000];
					int ponteiroPro=0;
					byte[] variaveis=new byte[10000];
					int ponteiroVar=0;
					byte[] textos=new byte[30000];
					int ponteiroTxt=0;
					int yw1=0;

					int ll=0;
					int contador=0;
					Byte vtxt=0;
					Byte vnum=1;
					Byte vrot=2;
					int fun=-1;

					ArrayList<Integer> endereco = new ArrayList<Integer>();
					ArrayList<String> nome = new ArrayList<String>();
					ArrayList<Integer> posicao = new ArrayList<Integer>();
					ArrayList<Byte> tipo = new ArrayList<Byte>();
					ArrayList<String> salto = new ArrayList<String>();

					try
					{

						File file=new File("/sdcard/uindex/" + TextEntered.toString());





						if (file.exists())
						{

							InputStream ins = getResources().openRawResource(R.raw.codex);

							ByteArrayOutputStream outputStream=new ByteArrayOutputStream();
							int size = 0;

							is = new FileInputStream(file);

							reader = new BufferedReader(new InputStreamReader(is));
							nome.add("linha");
							tipo.add(vtxt);
							endereco.add(ponteiroVar + 20000);
							int oooo=0xff & (ponteiroTxt + 30000);
							int ooooo=0xff00 & (ponteiroTxt + 30000);
							ooooo = ooooo >> 8;
							variaveis[ponteiroVar] = (byte) oooo;
							ponteiroVar++;
							variaveis[ponteiroVar] = (byte) ooooo;
							ponteiroVar++;
							textos[ponteiroTxt] = 13;
							ponteiroTxt++;
							textos[ponteiroTxt] = 10;
							ponteiroTxt++;
							textos[ponteiroTxt] = 0;
							ponteiroTxt++;


							String line = reader.readLine();
							ss = ss + "iniciar\n";

							while (line != null)
							{

								ll++;
								setTitle("linha:" + Integer.toString(ll));
								line = line.trim();
								line = line.replaceAll("  ", " ");

								if (line.length() > 0)
								{
									String[] temp1;


									temp1 = line.split(" ");







									if (temp1.length > 0)
									{
										fun = -1;

										if (temp1[0].compareToIgnoreCase("") == 0)fun = 0;
										if (temp1[0].compareToIgnoreCase("texto") == 0)fun = 1;
										if (temp1[0].compareToIgnoreCase("escrever") == 0)fun = 2;
										if (temp1[0].compareToIgnoreCase("esperar") == 0)fun = 3;
										if (temp1[0].compareToIgnoreCase("comentario") == 0)fun = 0;
										if (temp1[0].compareToIgnoreCase(";") == 0)fun = 0;
										if (temp1[0].compareToIgnoreCase("//") == 0)fun = 0;
										if (temp1[0].compareToIgnoreCase("/*") == 0)fun = 0;
										if (temp1[0].compareToIgnoreCase("'") == 0)fun = 0;
										if (temp1[0].compareToIgnoreCase("numero") == 0)fun = 4;
										if (temp1[0].compareToIgnoreCase("ler") == 0)fun = 5;
										if (temp1[0].compareToIgnoreCase("sair") == 0)fun = 6;
										if (temp1[0].compareToIgnoreCase(":") == 0)fun = 7;
										if (temp1[0].compareToIgnoreCase("vai") == 0)fun = 8;
										if (temp1[0].compareToIgnoreCase("index") == 0)fun = 9;
										if (temp1[0].compareToIgnoreCase("chamar") == 0)fun = 10;
										if (temp1[0].compareToIgnoreCase("retornar") == 0)fun = 6;
										if (temp1[0].compareToIgnoreCase("fim") == 0)fun = 11;
										if (temp1[0].compareToIgnoreCase("se") == 0)fun = 12;
										if (temp1[0].compareToIgnoreCase("somar") == 0)fun = 13;
										if (temp1[0].compareToIgnoreCase("igual") == 0)fun = 14;
										if (temp1[0].compareToIgnoreCase("grafico") == 0)fun = 15;
										if (temp1[0].compareToIgnoreCase("caixa") == 0)fun = 16;
										if (temp1[0].compareToIgnoreCase("definir") == 0)fun = 17;
										if (temp1[0].compareToIgnoreCase("copiar") == 0)fun = 18;
										if (temp1[0].compareToIgnoreCase("apontador") == 0)fun = 18;
										if (temp1[0].compareToIgnoreCase("de") == 0)fun = 19;
										if (temp1[0].compareToIgnoreCase("seguinte") == 0)fun = 20;
										if (temp1[0].compareToIgnoreCase("ate") == 0)fun = 21;
										if (temp1[0].compareToIgnoreCase("sequencia") == 0)fun = 22;
										if (temp1[0].compareToIgnoreCase("maior") == 0)fun = 23;
										if (temp1[0].compareToIgnoreCase("menor") == 0)fun = 24;
										if (temp1[0].compareToIgnoreCase("diferente") == 0)fun = 25;
										if (temp1[0].compareToIgnoreCase("sorte") == 0)fun = 26;
										if (temp1[0].compareToIgnoreCase("txt") == 0)fun = 27;
										if (temp1[0].compareToIgnoreCase("mostrar") == 0)fun = 28;
										if (temp1[0].compareToIgnoreCase("esconder") == 0)fun = 29;
										if (temp1[0].compareToIgnoreCase("zero") == 0)fun = 30;
										if (temp1[0].compareToIgnoreCase("formato") == 0)fun = 31;
										if (temp1[0].compareToIgnoreCase("memoria") == 0)fun = 32;
										if (temp1[0].compareToIgnoreCase("carater") == 0)fun = 33;
										if (temp1[0].compareToIgnoreCase("funcao") == 0)fun = 7;
										if (temp1[0].compareToIgnoreCase("processo") == 0)fun = 7;
										if (temp1[0].compareToIgnoreCase("e") == 0)fun = 34;
										if (temp1[0].compareToIgnoreCase("ou") == 0)fun = 35;
										if (temp1[0].compareToIgnoreCase("sutrair") == 0)fun = 36;
										if (temp1[0].compareToIgnoreCase("multiplicar") == 0)fun = 37;
										if (temp1[0].compareToIgnoreCase("defenir") == 0)fun = 17;
										if (temp1[0].compareToIgnoreCase("dividir") == 0)fun = 38;
										if (temp1[0].compareToIgnoreCase("nao") == 0)fun = 39;
										if (temp1[0].compareToIgnoreCase("tamanho") == 0)fun = 40;
										if (temp1[0].compareToIgnoreCase("pequena") == 0)fun = 41;
										if (temp1[0].compareToIgnoreCase("grande") == 0)fun = 42;
										if (temp1[0].compareToIgnoreCase("mover") == 0)fun = 43;
										if (temp1[0].compareToIgnoreCase("rato") == 0)fun = 44;
										if (temp1[0].compareToIgnoreCase("logica") == 0)fun = 45;
										if (temp1[0].compareToIgnoreCase("iniciar") == 0)fun = 46;
										
										
										
										switch (fun)
										{
											
											
											case 46:
												if (temp1.length == 1)
												{

													int add=0;
													int add2=0;
													int add3=0;
													int yw2=-1;
													int yw22=-1;
													int yw222=-1;

															


														program[ponteiroPro] = (byte) 0xbe;
														ponteiroPro++;

														int o = 0xff & (256 + (3 * 30));
														int oo = 0xff00 & (256 + (3 * 30));
														oo = oo >> 8;
														program[ponteiroPro] = (byte) o;
														ponteiroPro++;
														program[ponteiroPro] = (byte) oo;
														ponteiroPro++;

														program[ponteiroPro] = (byte) 0xff;
														ponteiroPro++;
														program[ponteiroPro] = (byte) 0xd6;
														ponteiroPro++;


													



												}
												else
												{
													ss = ss + "erro escrever numero de parametros errado linha:" + Integer.toString(ll) + "\n";
												}
												break;
												
											
											
											
											
											case 45:
												if (temp1.length == 3)
												{

													int add=0;
													int yw2=-1;
													int yw22=-1;

													for (int uuu=0;uuu < nome.size();uuu++)
													{

														if (nome.get(uuu).toString().compareToIgnoreCase(temp1[2].toString().trim()) == 0)
														{
															yw2 = uuu;
															uuu = nome.size() + 200;
														}
													}
													for (int uuu=0;uuu < nome.size();uuu++)
													{

														if (nome.get(uuu).toString().compareToIgnoreCase(temp1[1].toString().trim()) == 0)
														{
															yw22 = uuu;
															add = endereco.get(uuu);
															uuu = nome.size() + 200;
														}
													}



													if (yw22 != -1)
													{
														if (yw2 == -1)
														{
															nome.add(temp1[2].toString().trim());
															tipo.add(vtxt);
															endereco.add(ponteiroVar + 20000);
															int o=0xff & (ponteiroPro + 10000);
															int oo=0xff00 & (ponteiroPro + 10000);
															oo = oo >> 8;
															variaveis[ponteiroVar] = (byte) 0;



															program[ponteiroPro] = (byte) 0xbd;
															ponteiroPro++;
															o = 0xff & (ponteiroVar + 20000);
															oo = 0xff00 & (ponteiroVar + 20000);
															ponteiroVar++;
															variaveis[ponteiroVar] = (byte) 0;
															ponteiroVar++;
															oo = oo >> 8;
															program[ponteiroPro] = (byte) o;
															ponteiroPro++;
															program[ponteiroPro] = (byte) oo;
															ponteiroPro++;
															program[ponteiroPro] = (byte) 0x8b;
															ponteiroPro++;
															program[ponteiroPro] = (byte) 0x46;
															ponteiroPro++;
															program[ponteiroPro] = (byte) 0x0;
															ponteiroPro++;
															o = 0xff & (add);
															oo = 0xff00 & (add);
															oo = oo >> 8;
															program[ponteiroPro] = (byte) 0xbd;
															ponteiroPro++;
															program[ponteiroPro] = (byte) o;
															ponteiroPro++;
															program[ponteiroPro] = (byte) oo;
															ponteiroPro++;

															program[ponteiroPro] = (byte) 0x8b;
															ponteiroPro++;

															program[ponteiroPro] = (byte) 0x4e;
															ponteiroPro++;

															program[ponteiroPro] = (byte) 0;
															ponteiroPro++;

															program[ponteiroPro] = (byte) 0x83;
															ponteiroPro++;

															program[ponteiroPro] = (byte) 0xf9;
															ponteiroPro++;

															program[ponteiroPro] = (byte) 0x0;
															ponteiroPro++;

															program[ponteiroPro] = (byte) 0x74;
															ponteiroPro++;

															program[ponteiroPro] = (byte) 0x2;
															ponteiroPro++;

															program[ponteiroPro] = (byte) 0xff;
															ponteiroPro++;

															program[ponteiroPro] = (byte) 0xd0;
															ponteiroPro++;







															salto.add(temp1[2].toString().trim());
															posicao.add(ll);
														}

														else
														{
															int iii=endereco.get(yw2);
															program[ponteiroPro] = (byte) 0xbd;
															ponteiroPro++;
															int o = 0xff & (iii);
															int oo = 0xff00 & (iii);
															variaveis[ponteiroVar] = (byte) 0;
															ponteiroVar++;
															variaveis[ponteiroVar] = (byte) 0;

															ponteiroVar++;

															oo = oo >> 8;
															program[ponteiroPro] = (byte) o;
															ponteiroPro++;
															program[ponteiroPro] = (byte) oo;
															ponteiroPro++;
															program[ponteiroPro] = (byte) 0x8b;
															ponteiroPro++;
															program[ponteiroPro] = (byte) 0x46;
															ponteiroPro++;
															program[ponteiroPro] = (byte) 0x0;
															ponteiroPro++;

															o = 0xff & (add);
															oo = 0xff00 & (add);
															oo = oo >> 8;
															program[ponteiroPro] = (byte) 0xbd;
															ponteiroPro++;
															program[ponteiroPro] = (byte) o;
															ponteiroPro++;
															program[ponteiroPro] = (byte) oo;
															ponteiroPro++;



															program[ponteiroPro] = (byte) 0x8b;
															ponteiroPro++;

															program[ponteiroPro] = (byte) 0x4e;
															ponteiroPro++;

															program[ponteiroPro] = (byte) 0x0;
															ponteiroPro++;



															program[ponteiroPro] = (byte) 0x83;
															ponteiroPro++;

															program[ponteiroPro] = (byte) 0xf9;
															ponteiroPro++;

															program[ponteiroPro] = (byte) 0x0;
															ponteiroPro++;

															program[ponteiroPro] = (byte) 0x74;
															ponteiroPro++;

															program[ponteiroPro] = (byte) 0x2;
															ponteiroPro++;

															program[ponteiroPro] = (byte) 0xff;
															ponteiroPro++;

															program[ponteiroPro] = (byte) 0xd0;
															ponteiroPro++;





														}
													}

													else
													{

														ss = ss + "erro variavel texto numero parametros linha:" + Integer.toString(ll) + "\n";
													}

												}
												else
												{
													ss = ss + "erro escrever numero de parametros errado linha:" + Integer.toString(ll) + "\n";
												}
												break;
											
											
											case 44:
												if (temp1.length == 4)
												{

													int add=0;
													int add2=0;
													int add3=0;
													int yw2=-1;
													int yw22=-1;
													int yw222=-1;

													for (int uuu=0;uuu < nome.size();uuu++)
													{

														if (nome.get(uuu).toString().compareToIgnoreCase(temp1[1].toString().trim()) == 0)
														{
															yw2 = uuu;
															add = endereco.get(uuu);
															uuu = nome.size() + 200;
														}
													}
													for (int uuu=0;uuu < nome.size();uuu++)
													{

														if (nome.get(uuu).toString().compareToIgnoreCase(temp1[2].toString().trim()) == 0)
														{
															yw22 = uuu;
															add2 = endereco.get(uuu);
															uuu = nome.size() + 200;
														}
													}


													for (int uuu=0;uuu < nome.size();uuu++)
													{

														if (nome.get(uuu).toString().compareToIgnoreCase(temp1[3].toString().trim()) == 0)
														{
															yw222 = uuu;
															add3 = endereco.get(uuu);
															uuu = nome.size() + 200;
														}
													}


													if (yw22 != -1 && yw2 != -1 && yw222!=-1 )
													{

														program[ponteiroPro] = (byte) 0xbd;
														ponteiroPro++;


														int o=0xff & (add2);
														int oo=0xff00 & (add2);
														oo = oo >> 8;
														program[ponteiroPro] = (byte) o;
														ponteiroPro++;
														program[ponteiroPro] = (byte) oo;
														ponteiroPro++;


														program[ponteiroPro] = (byte) 0xbb;
														ponteiroPro++;


														o = 0xff & (add);
														oo = 0xff00 & (add);
														oo = oo >> 8;
														program[ponteiroPro] = (byte) o;
														ponteiroPro++;
														program[ponteiroPro] = (byte) oo;
														ponteiroPro++;

														program[ponteiroPro] = (byte) 0xbf;
														ponteiroPro++;


														o=0xff & (add3);
														oo=0xff00 & (add3);
														oo = oo >> 8;
														program[ponteiroPro] = (byte) o;
														ponteiroPro++;
														program[ponteiroPro] = (byte) oo;
														ponteiroPro++;



														program[ponteiroPro] = (byte) 0xbe;
														ponteiroPro++;

														o = 0xff & (256 + (3 * 29));
														oo = 0xff00 & (256 + (3 * 29));
														oo = oo >> 8;
														program[ponteiroPro] = (byte) o;
														ponteiroPro++;
														program[ponteiroPro] = (byte) oo;
														ponteiroPro++;

														program[ponteiroPro] = (byte) 0xff;
														ponteiroPro++;
														program[ponteiroPro] = (byte) 0xd6;
														ponteiroPro++;


													}



													else
													{

														ss = ss + "erro variavel texto numero parametros linha:" + Integer.toString(ll) + "\n";
													}

												}
												else
												{
													ss = ss + "erro escrever numero de parametros errado linha:" + Integer.toString(ll) + "\n";
												}
												break;

												
											

											case 43:
												if (temp1.length == 4)
												{

													int add=0;
													int add2=0;
													int add3=0;
													int yw2=-1;
													int yw22=-1;
													int yw222=-1;

													for (int uuu=0;uuu < nome.size();uuu++)
													{

														if (nome.get(uuu).toString().compareToIgnoreCase(temp1[1].toString().trim()) == 0)
														{
															yw2 = uuu;
															add = endereco.get(uuu);
															uuu = nome.size() + 200;
														}
													}
													for (int uuu=0;uuu < nome.size();uuu++)
													{

														if (nome.get(uuu).toString().compareToIgnoreCase(temp1[2].toString().trim()) == 0)
														{
															yw22 = uuu;
															add2 = endereco.get(uuu);
															uuu = nome.size() + 200;
														}
													}


													for (int uuu=0;uuu < nome.size();uuu++)
													{

														if (nome.get(uuu).toString().compareToIgnoreCase(temp1[3].toString().trim()) == 0)
														{
															yw222 = uuu;
															add3 = endereco.get(uuu);
															uuu = nome.size() + 200;
														}
													}
													

													if (yw22 != -1 && yw2 != -1 && yw222!=-1 )
													{

														program[ponteiroPro] = (byte) 0xbd;
														ponteiroPro++;


														int o=0xff & (add2);
														int oo=0xff00 & (add2);
														oo = oo >> 8;
														program[ponteiroPro] = (byte) o;
														ponteiroPro++;
														program[ponteiroPro] = (byte) oo;
														ponteiroPro++;


														program[ponteiroPro] = (byte) 0xbb;
														ponteiroPro++;


														o = 0xff & (add);
														oo = 0xff00 & (add);
														oo = oo >> 8;
														program[ponteiroPro] = (byte) o;
														ponteiroPro++;
														program[ponteiroPro] = (byte) oo;
														ponteiroPro++;

														program[ponteiroPro] = (byte) 0xbf;
														ponteiroPro++;


														o=0xff & (add3);
														oo=0xff00 & (add3);
														oo = oo >> 8;
														program[ponteiroPro] = (byte) o;
														ponteiroPro++;
														program[ponteiroPro] = (byte) oo;
														ponteiroPro++;
														


														program[ponteiroPro] = (byte) 0xbe;
														ponteiroPro++;

														o = 0xff & (256 + (3 * 28));
														oo = 0xff00 & (256 + (3 * 28));
														oo = oo >> 8;
														program[ponteiroPro] = (byte) o;
														ponteiroPro++;
														program[ponteiroPro] = (byte) oo;
														ponteiroPro++;

														program[ponteiroPro] = (byte) 0xff;
														ponteiroPro++;
														program[ponteiroPro] = (byte) 0xd6;
														ponteiroPro++;


													}



													else
													{

														ss = ss + "erro variavel texto numero parametros linha:" + Integer.toString(ll) + "\n";
													}

												}
												else
												{
													ss = ss + "erro escrever numero de parametros errado linha:" + Integer.toString(ll) + "\n";
												}
												break;
												
											
											
											case 42:
												if (temp1.length == 2)
												{

													int add=0;
													int add2=0;
													int add3=0;
													int yw2=-1;
													int yw22=-1;
													int yw222=-1;

													for (int uuu=0;uuu < nome.size();uuu++)
													{

														if (nome.get(uuu).toString().compareToIgnoreCase(temp1[1].toString().trim()) == 0)
														{
															yw2 = uuu;
															add = endereco.get(uuu);
															uuu = nome.size() + 200;
														}
													}




													if (yw2 != -1 )
													{



														program[ponteiroPro] = (byte) 0xbb;
														ponteiroPro++;


														int o = 0xff & (add);
														int oo = 0xff00 & (add);
														oo = oo >> 8;
														program[ponteiroPro] = (byte) o;
														ponteiroPro++;
														program[ponteiroPro] = (byte) oo;
														ponteiroPro++;




														program[ponteiroPro] = (byte) 0xbe;
														ponteiroPro++;

														o = 0xff & (256 + (3 * 27));
														oo = 0xff00 & (256 + (3 * 27));
														oo = oo >> 8;
														program[ponteiroPro] = (byte) o;
														ponteiroPro++;
														program[ponteiroPro] = (byte) oo;
														ponteiroPro++;

														program[ponteiroPro] = (byte) 0xff;
														ponteiroPro++;
														program[ponteiroPro] = (byte) 0xd6;
														ponteiroPro++;


													}



													else
													{

														ss = ss + "erro variavel texto numero parametros linha:" + Integer.toString(ll) + "\n";
													}

												}
												else
												{
													ss = ss + "erro escrever numero de parametros errado linha:" + Integer.toString(ll) + "\n";
												}
												break;
												
											


											case 41:
												if (temp1.length == 2)
												{

													int add=0;
													int add2=0;
													int add3=0;
													int yw2=-1;
													int yw22=-1;
													int yw222=-1;

													for (int uuu=0;uuu < nome.size();uuu++)
													{

														if (nome.get(uuu).toString().compareToIgnoreCase(temp1[1].toString().trim()) == 0)
														{
															yw2 = uuu;
															add = endereco.get(uuu);
															uuu = nome.size() + 200;
														}
													}




													if (yw2 != -1 )
													{



														program[ponteiroPro] = (byte) 0xbb;
														ponteiroPro++;


														int o = 0xff & (add);
														int oo = 0xff00 & (add);
														oo = oo >> 8;
														program[ponteiroPro] = (byte) o;
														ponteiroPro++;
														program[ponteiroPro] = (byte) oo;
														ponteiroPro++;




														program[ponteiroPro] = (byte) 0xbe;
														ponteiroPro++;

														o = 0xff & (256 + (3 * 26));
														oo = 0xff00 & (256 + (3 * 26));
														oo = oo >> 8;
														program[ponteiroPro] = (byte) o;
														ponteiroPro++;
														program[ponteiroPro] = (byte) oo;
														ponteiroPro++;

														program[ponteiroPro] = (byte) 0xff;
														ponteiroPro++;
														program[ponteiroPro] = (byte) 0xd6;
														ponteiroPro++;


													}



													else
													{

														ss = ss + "erro variavel texto numero parametros linha:" + Integer.toString(ll) + "\n";
													}

												}
												else
												{
													ss = ss + "erro escrever numero de parametros errado linha:" + Integer.toString(ll) + "\n";
												}
												break;



												
											
											case 40:
												if (temp1.length == 3)
												{

													int add=0;
													int add2=0;
													int add3=0;
													int yw2=-1;
													int yw22=-1;
													int yw222=-1;

													for (int uuu=0;uuu < nome.size();uuu++)
													{

														if (nome.get(uuu).toString().compareToIgnoreCase(temp1[1].toString().trim()) == 0)
														{
															yw2 = uuu;
															add = endereco.get(uuu);
															uuu = nome.size() + 200;
														}
													}
													for (int uuu=0;uuu < nome.size();uuu++)
													{

														if (nome.get(uuu).toString().compareToIgnoreCase(temp1[2].toString().trim()) == 0)
														{
															yw22 = uuu;
															add2 = endereco.get(uuu);
															uuu = nome.size() + 200;
														}
													}



													if (yw22 != -1 && yw2 != -1 )
													{

														program[ponteiroPro] = (byte) 0xbd;
														ponteiroPro++;


														int o=0xff & (add2);
														int oo=0xff00 & (add2);
														oo = oo >> 8;
														program[ponteiroPro] = (byte) o;
														ponteiroPro++;
														program[ponteiroPro] = (byte) oo;
														ponteiroPro++;


														program[ponteiroPro] = (byte) 0xbb;
														ponteiroPro++;


														o = 0xff & (add);
														oo = 0xff00 & (add);
														oo = oo >> 8;
														program[ponteiroPro] = (byte) o;
														ponteiroPro++;
														program[ponteiroPro] = (byte) oo;
														ponteiroPro++;




														program[ponteiroPro] = (byte) 0xbe;
														ponteiroPro++;

														o = 0xff & (256 + (3 * 25));
														oo = 0xff00 & (256 + (3 * 25));
														oo = oo >> 8;
														program[ponteiroPro] = (byte) o;
														ponteiroPro++;
														program[ponteiroPro] = (byte) oo;
														ponteiroPro++;

														program[ponteiroPro] = (byte) 0xff;
														ponteiroPro++;
														program[ponteiroPro] = (byte) 0xd6;
														ponteiroPro++;


													}



													else
													{

														ss = ss + "erro variavel texto numero parametros linha:" + Integer.toString(ll) + "\n";
													}

												}
												else
												{
													ss = ss + "erro escrever numero de parametros errado linha:" + Integer.toString(ll) + "\n";
												}
												break;


												
											

											case 39:
												if (temp1.length == 2)
												{

													int add=0;
													int add2=0;
													int add3=0;
													int yw2=-1;
													int yw22=-1;
													int yw222=-1;

													for (int uuu=0;uuu < nome.size();uuu++)
													{

														if (nome.get(uuu).toString().compareToIgnoreCase(temp1[1].toString().trim()) == 0)
														{
															yw2 = uuu;
															add = endereco.get(uuu);
															uuu = nome.size() + 200;
														}
													}
													



													if (yw2 != -1 )
													{

														

														program[ponteiroPro] = (byte) 0xbb;
														ponteiroPro++;


														int o = 0xff & (add);
														int oo = 0xff00 & (add);
														oo = oo >> 8;
														program[ponteiroPro] = (byte) o;
														ponteiroPro++;
														program[ponteiroPro] = (byte) oo;
														ponteiroPro++;




														program[ponteiroPro] = (byte) 0xbe;
														ponteiroPro++;

														o = 0xff & (256 + (3 * 24));
														oo = 0xff00 & (256 + (3 * 24));
														oo = oo >> 8;
														program[ponteiroPro] = (byte) o;
														ponteiroPro++;
														program[ponteiroPro] = (byte) oo;
														ponteiroPro++;

														program[ponteiroPro] = (byte) 0xff;
														ponteiroPro++;
														program[ponteiroPro] = (byte) 0xd6;
														ponteiroPro++;


													}



													else
													{

														ss = ss + "erro variavel texto numero parametros linha:" + Integer.toString(ll) + "\n";
													}

												}
												else
												{
													ss = ss + "erro escrever numero de parametros errado linha:" + Integer.toString(ll) + "\n";
												}
												break;

												
											
											

											case 38:
												if (temp1.length == 3)
												{

													int add=0;
													int add2=0;
													int add3=0;
													int yw2=-1;
													int yw22=-1;
													int yw222=-1;

													for (int uuu=0;uuu < nome.size();uuu++)
													{

														if (nome.get(uuu).toString().compareToIgnoreCase(temp1[1].toString().trim()) == 0)
														{
															yw2 = uuu;
															add = endereco.get(uuu);
															uuu = nome.size() + 200;
														}
													}
													for (int uuu=0;uuu < nome.size();uuu++)
													{

														if (nome.get(uuu).toString().compareToIgnoreCase(temp1[2].toString().trim()) == 0)
														{
															yw22 = uuu;
															add2 = endereco.get(uuu);
															uuu = nome.size() + 200;
														}
													}



													if (yw22 != -1 && yw2 != -1 )
													{

														program[ponteiroPro] = (byte) 0xbd;
														ponteiroPro++;


														int o=0xff & (add2);
														int oo=0xff00 & (add2);
														oo = oo >> 8;
														program[ponteiroPro] = (byte) o;
														ponteiroPro++;
														program[ponteiroPro] = (byte) oo;
														ponteiroPro++;


														program[ponteiroPro] = (byte) 0xbb;
														ponteiroPro++;


														o = 0xff & (add);
														oo = 0xff00 & (add);
														oo = oo >> 8;
														program[ponteiroPro] = (byte) o;
														ponteiroPro++;
														program[ponteiroPro] = (byte) oo;
														ponteiroPro++;




														program[ponteiroPro] = (byte) 0xbe;
														ponteiroPro++;

														o = 0xff & (256 + (3 * 23));
														oo = 0xff00 & (256 + (3 * 23));
														oo = oo >> 8;
														program[ponteiroPro] = (byte) o;
														ponteiroPro++;
														program[ponteiroPro] = (byte) oo;
														ponteiroPro++;

														program[ponteiroPro] = (byte) 0xff;
														ponteiroPro++;
														program[ponteiroPro] = (byte) 0xd6;
														ponteiroPro++;


													}



													else
													{

														ss = ss + "erro variavel texto numero parametros linha:" + Integer.toString(ll) + "\n";
													}

												}
												else
												{
													ss = ss + "erro escrever numero de parametros errado linha:" + Integer.toString(ll) + "\n";
												}
												break;
												
											
											
											
											case 37:
												if (temp1.length == 3)
												{

													int add=0;
													int add2=0;
													int add3=0;
													int yw2=-1;
													int yw22=-1;
													int yw222=-1;

													for (int uuu=0;uuu < nome.size();uuu++)
													{

														if (nome.get(uuu).toString().compareToIgnoreCase(temp1[1].toString().trim()) == 0)
														{
															yw2 = uuu;
															add = endereco.get(uuu);
															uuu = nome.size() + 200;
														}
													}
													for (int uuu=0;uuu < nome.size();uuu++)
													{

														if (nome.get(uuu).toString().compareToIgnoreCase(temp1[2].toString().trim()) == 0)
														{
															yw22 = uuu;
															add2 = endereco.get(uuu);
															uuu = nome.size() + 200;
														}
													}



													if (yw22 != -1 && yw2 != -1 )
													{

														program[ponteiroPro] = (byte) 0xbd;
														ponteiroPro++;


														int o=0xff & (add2);
														int oo=0xff00 & (add2);
														oo = oo >> 8;
														program[ponteiroPro] = (byte) o;
														ponteiroPro++;
														program[ponteiroPro] = (byte) oo;
														ponteiroPro++;


														program[ponteiroPro] = (byte) 0xbb;
														ponteiroPro++;


														o = 0xff & (add);
														oo = 0xff00 & (add);
														oo = oo >> 8;
														program[ponteiroPro] = (byte) o;
														ponteiroPro++;
														program[ponteiroPro] = (byte) oo;
														ponteiroPro++;




														program[ponteiroPro] = (byte) 0xbe;
														ponteiroPro++;

														o = 0xff & (256 + (3 * 22));
														oo = 0xff00 & (256 + (3 * 22));
														oo = oo >> 8;
														program[ponteiroPro] = (byte) o;
														ponteiroPro++;
														program[ponteiroPro] = (byte) oo;
														ponteiroPro++;

														program[ponteiroPro] = (byte) 0xff;
														ponteiroPro++;
														program[ponteiroPro] = (byte) 0xd6;
														ponteiroPro++;


													}



													else
													{

														ss = ss + "erro variavel texto numero parametros linha:" + Integer.toString(ll) + "\n";
													}

												}
												else
												{
													ss = ss + "erro escrever numero de parametros errado linha:" + Integer.toString(ll) + "\n";
												}
												break;

												
											
											
											
											case 36:
												if (temp1.length == 3)
												{

													int add=0;
													int add2=0;
													int add3=0;
													int yw2=-1;
													int yw22=-1;
													int yw222=-1;

													for (int uuu=0;uuu < nome.size();uuu++)
													{

														if (nome.get(uuu).toString().compareToIgnoreCase(temp1[1].toString().trim()) == 0)
														{
															yw2 = uuu;
															add = endereco.get(uuu);
															uuu = nome.size() + 200;
														}
													}
													for (int uuu=0;uuu < nome.size();uuu++)
													{

														if (nome.get(uuu).toString().compareToIgnoreCase(temp1[2].toString().trim()) == 0)
														{
															yw22 = uuu;
															add2 = endereco.get(uuu);
															uuu = nome.size() + 200;
														}
													}



													if (yw22 != -1 && yw2 != -1 )
													{

														program[ponteiroPro] = (byte) 0xbd;
														ponteiroPro++;


														int o=0xff & (add2);
														int oo=0xff00 & (add2);
														oo = oo >> 8;
														program[ponteiroPro] = (byte) o;
														ponteiroPro++;
														program[ponteiroPro] = (byte) oo;
														ponteiroPro++;


														program[ponteiroPro] = (byte) 0xbb;
														ponteiroPro++;


														o = 0xff & (add);
														oo = 0xff00 & (add);
														oo = oo >> 8;
														program[ponteiroPro] = (byte) o;
														ponteiroPro++;
														program[ponteiroPro] = (byte) oo;
														ponteiroPro++;




														program[ponteiroPro] = (byte) 0xbe;
														ponteiroPro++;

														o = 0xff & (256 + (3 * 21));
														oo = 0xff00 & (256 + (3 * 21));
														oo = oo >> 8;
														program[ponteiroPro] = (byte) o;
														ponteiroPro++;
														program[ponteiroPro] = (byte) oo;
														ponteiroPro++;

														program[ponteiroPro] = (byte) 0xff;
														ponteiroPro++;
														program[ponteiroPro] = (byte) 0xd6;
														ponteiroPro++;


													}



													else
													{

														ss = ss + "erro variavel texto numero parametros linha:" + Integer.toString(ll) + "\n";
													}

												}
												else
												{
													ss = ss + "erro escrever numero de parametros errado linha:" + Integer.toString(ll) + "\n";
												}
												break;
												
											
											
											
											
											
											case 35:
												if (temp1.length == 3)
												{

													int add=0;
													int add2=0;
													int add3=0;
													int yw2=-1;
													int yw22=-1;
													int yw222=-1;

													for (int uuu=0;uuu < nome.size();uuu++)
													{

														if (nome.get(uuu).toString().compareToIgnoreCase(temp1[1].toString().trim()) == 0)
														{
															yw2 = uuu;
															add = endereco.get(uuu);
															uuu = nome.size() + 200;
														}
													}
													for (int uuu=0;uuu < nome.size();uuu++)
													{

														if (nome.get(uuu).toString().compareToIgnoreCase(temp1[2].toString().trim()) == 0)
														{
															yw22 = uuu;
															add2 = endereco.get(uuu);
															uuu = nome.size() + 200;
														}
													}



													if (yw22 != -1 && yw2 != -1 )
													{

														program[ponteiroPro] = (byte) 0xbd;
														ponteiroPro++;


														int o=0xff & (add2);
														int oo=0xff00 & (add2);
														oo = oo >> 8;
														program[ponteiroPro] = (byte) o;
														ponteiroPro++;
														program[ponteiroPro] = (byte) oo;
														ponteiroPro++;


														program[ponteiroPro] = (byte) 0xbb;
														ponteiroPro++;


														o = 0xff & (add);
														oo = 0xff00 & (add);
														oo = oo >> 8;
														program[ponteiroPro] = (byte) o;
														ponteiroPro++;
														program[ponteiroPro] = (byte) oo;
														ponteiroPro++;




														program[ponteiroPro] = (byte) 0xbe;
														ponteiroPro++;

														o = 0xff & (256 + (3 * 20));
														oo = 0xff00 & (256 + (3 * 20));
														oo = oo >> 8;
														program[ponteiroPro] = (byte) o;
														ponteiroPro++;
														program[ponteiroPro] = (byte) oo;
														ponteiroPro++;

														program[ponteiroPro] = (byte) 0xff;
														ponteiroPro++;
														program[ponteiroPro] = (byte) 0xd6;
														ponteiroPro++;


													}



													else
													{

														ss = ss + "erro variavel texto numero parametros linha:" + Integer.toString(ll) + "\n";
													}

												}
												else
												{
													ss = ss + "erro escrever numero de parametros errado linha:" + Integer.toString(ll) + "\n";
												}
												break;

												
											

											case 34:
												if (temp1.length == 3)
												{

													int add=0;
													int add2=0;
													int add3=0;
													int yw2=-1;
													int yw22=-1;
													int yw222=-1;

													for (int uuu=0;uuu < nome.size();uuu++)
													{

														if (nome.get(uuu).toString().compareToIgnoreCase(temp1[1].toString().trim()) == 0)
														{
															yw2 = uuu;
															add = endereco.get(uuu);
															uuu = nome.size() + 200;
														}
													}
													for (int uuu=0;uuu < nome.size();uuu++)
													{

														if (nome.get(uuu).toString().compareToIgnoreCase(temp1[2].toString().trim()) == 0)
														{
															yw22 = uuu;
															add2 = endereco.get(uuu);
															uuu = nome.size() + 200;
														}
													}



													if (yw22 != -1 && yw2 != -1 )
													{

														program[ponteiroPro] = (byte) 0xbd;
														ponteiroPro++;


														int o=0xff & (add2);
														int oo=0xff00 & (add2);
														oo = oo >> 8;
														program[ponteiroPro] = (byte) o;
														ponteiroPro++;
														program[ponteiroPro] = (byte) oo;
														ponteiroPro++;


														program[ponteiroPro] = (byte) 0xbb;
														ponteiroPro++;


														o = 0xff & (add);
														oo = 0xff00 & (add);
														oo = oo >> 8;
														program[ponteiroPro] = (byte) o;
														ponteiroPro++;
														program[ponteiroPro] = (byte) oo;
														ponteiroPro++;




														program[ponteiroPro] = (byte) 0xbe;
														ponteiroPro++;

														o = 0xff & (256 + (3 * 19));
														oo = 0xff00 & (256 + (3 * 19));
														oo = oo >> 8;
														program[ponteiroPro] = (byte) o;
														ponteiroPro++;
														program[ponteiroPro] = (byte) oo;
														ponteiroPro++;

														program[ponteiroPro] = (byte) 0xff;
														ponteiroPro++;
														program[ponteiroPro] = (byte) 0xd6;
														ponteiroPro++;


													}



													else
													{

														ss = ss + "erro variavel texto numero parametros linha:" + Integer.toString(ll) + "\n";
													}

												}
												else
												{
													ss = ss + "erro escrever numero de parametros errado linha:" + Integer.toString(ll) + "\n";
												}
												break;
											
											
											case 33:
												if (temp1.length == 3)
												{

													int add=0;
													int add2=0;
													int add3=0;
													int yw2=-1;
													int yw22=-1;
													int yw222=-1;

													for (int uuu=0;uuu < nome.size();uuu++)
													{

														if (nome.get(uuu).toString().compareToIgnoreCase(temp1[1].toString().trim()) == 0)
														{
															yw2 = uuu;
															add = endereco.get(uuu);
															uuu = nome.size() + 200;
														}
													}
													for (int uuu=0;uuu < nome.size();uuu++)
													{

														if (nome.get(uuu).toString().compareToIgnoreCase(temp1[2].toString().trim()) == 0)
														{
															yw22 = uuu;
															add2 = endereco.get(uuu);
															uuu = nome.size() + 200;
														}
													}



													if (yw22 != -1 && yw2 != -1 )
													{

														program[ponteiroPro] = (byte) 0xbd;
														ponteiroPro++;


														int o=0xff & (add2);
														int oo=0xff00 & (add2);
														oo = oo >> 8;
														program[ponteiroPro] = (byte) o;
														ponteiroPro++;
														program[ponteiroPro] = (byte) oo;
														ponteiroPro++;


														program[ponteiroPro] = (byte) 0xbb;
														ponteiroPro++;


														o = 0xff & (add);
														oo = 0xff00 & (add);
														oo = oo >> 8;
														program[ponteiroPro] = (byte) o;
														ponteiroPro++;
														program[ponteiroPro] = (byte) oo;
														ponteiroPro++;




														program[ponteiroPro] = (byte) 0xbe;
														ponteiroPro++;

														o = 0xff & (256 + (3 * 18));
														oo = 0xff00 & (256 + (3 * 18));
														oo = oo >> 8;
														program[ponteiroPro] = (byte) o;
														ponteiroPro++;
														program[ponteiroPro] = (byte) oo;
														ponteiroPro++;

														program[ponteiroPro] = (byte) 0xff;
														ponteiroPro++;
														program[ponteiroPro] = (byte) 0xd6;
														ponteiroPro++;


													}



													else
													{

														ss = ss + "erro variavel texto numero parametros linha:" + Integer.toString(ll) + "\n";
													}

												}
												else
												{
													ss = ss + "erro escrever numero de parametros errado linha:" + Integer.toString(ll) + "\n";
												}
												break;
											
											case 32:
												if (temp1.length == 3)
												{

													int add=0;
													int add2=0;
													int add3=0;
													int yw2=-1;
													int yw22=-1;
													int yw222=-1;

													for (int uuu=0;uuu < nome.size();uuu++)
													{

														if (nome.get(uuu).toString().compareToIgnoreCase(temp1[1].toString().trim()) == 0)
														{
															yw2 = uuu;
															add = endereco.get(uuu);
															uuu = nome.size() + 200;
														}
													}
													for (int uuu=0;uuu < nome.size();uuu++)
													{

														if (nome.get(uuu).toString().compareToIgnoreCase(temp1[2].toString().trim()) == 0)
														{
															yw22 = uuu;
															add2 = endereco.get(uuu);
															uuu = nome.size() + 200;
														}
													}



													if (yw22 != -1 && yw2 != -1 )
													{

														program[ponteiroPro] = (byte) 0xbd;
														ponteiroPro++;


														int o=0xff & (add2);
														int oo=0xff00 & (add2);
														oo = oo >> 8;
														program[ponteiroPro] = (byte) o;
														ponteiroPro++;
														program[ponteiroPro] = (byte) oo;
														ponteiroPro++;


														program[ponteiroPro] = (byte) 0xbb;
														ponteiroPro++;


														o = 0xff & (add);
														oo = 0xff00 & (add);
														oo = oo >> 8;
														program[ponteiroPro] = (byte) o;
														ponteiroPro++;
														program[ponteiroPro] = (byte) oo;
														ponteiroPro++;




														program[ponteiroPro] = (byte) 0xbe;
														ponteiroPro++;

														o = 0xff & (256 + (3 * 17));
														oo = 0xff00 & (256 + (3 * 17));
														oo = oo >> 8;
														program[ponteiroPro] = (byte) o;
														ponteiroPro++;
														program[ponteiroPro] = (byte) oo;
														ponteiroPro++;

														program[ponteiroPro] = (byte) 0xff;
														ponteiroPro++;
														program[ponteiroPro] = (byte) 0xd6;
														ponteiroPro++;


													}



													else
													{

														ss = ss + "erro variavel texto numero parametros linha:" + Integer.toString(ll) + "\n";
													}

												}
												else
												{
													ss = ss + "erro escrever numero de parametros errado linha:" + Integer.toString(ll) + "\n";
												}
												break;
											

											case 1:
												yw1 = 0;


												if (temp1.length > 2)
												{


													int yw2=-1;

													for (int uuu=0;uuu < nome.size();uuu++)
													{

														if (nome.get(uuu).toString().compareToIgnoreCase(temp1[1].toString().trim()) == 0)
														{
															yw2 = uuu;
															ss = ss + "erro esta variavel ja foi defenida:"  + temp1[1].toString().trim() + ";linha:" + Integer.toString(ll) + "\n";
															uuu = nome.size() + 100;
														}
													}
													nome.add(temp1[1].toString().trim());
													tipo.add(vtxt);
													endereco.add(ponteiroVar + 20000);
													int o=0xff & (ponteiroTxt + 30000);
													int oo=0xff00 & (ponteiroTxt + 30000);
													oo = oo >> 8;
													variaveis[ponteiroVar] = (byte) o;
													ponteiroVar++;
													variaveis[ponteiroVar] = (byte) oo;
													ponteiroVar++;

													for (int ttt=2;ttt < temp1.length;ttt++)
													{
														String st=temp1[ttt];
														for (int uuu=0;uuu < st.length();uuu++)
														{
															if (st.charAt(uuu) == '#')
															{
																textos[ponteiroTxt] = 13;
																ponteiroTxt++;
																textos[ponteiroTxt] = 10;
																ponteiroTxt++;
															}
															else
															{
																textos[ponteiroTxt] = (byte)st.charAt(uuu);
																ponteiroTxt++;
															}
														}
														if (ttt != temp1.length - 1)
														{
															textos[ponteiroTxt] = 32;
															ponteiroTxt++;
														}
													}
													textos[ponteiroTxt] = 0;
													ponteiroTxt++;
												}
												else
												{

													ss = ss + "erro variavel texto numero parametros linha:" + Integer.toString(ll) + "\n";
												}
												break;
											case 2:
												if (temp1.length == 2)
												{


													int yw2=-1;

													for (int uuu=0;uuu < nome.size();uuu++)
													{

														if (nome.get(uuu).toString().compareToIgnoreCase(temp1[1].toString().trim()) == 0)
														{
															yw2 = uuu;
															uuu = nome.size() + 200;
														}
													}
													if (yw2 != -1)
													{
														program[ponteiroPro] = (byte) 0xb8;
														ponteiroPro++;
														int o=0xff & (endereco.get(yw2));
														int oo=0xff00 & (endereco.get(yw2));
														oo = oo >> 8;
														program[ponteiroPro] = (byte) o;
														ponteiroPro++;
														program[ponteiroPro] = (byte) oo;
														ponteiroPro++;

														program[ponteiroPro] = (byte) 0xbe;
														ponteiroPro++;
														o = 0xff & (256 + 3);
														oo = 0xff00 & (256 + 3);
														oo = oo >> 8;
														program[ponteiroPro] = (byte) o;
														ponteiroPro++;
														program[ponteiroPro] = (byte) oo;
														ponteiroPro++;
														program[ponteiroPro] = (byte) 0xff;
														ponteiroPro++;
														program[ponteiroPro] = (byte) 0xd6;
														ponteiroPro++;
													}
													else
													{
														ss = ss + "erro escrever nome variavel indefinido errado linha:" + Integer.toString(ll) + "\n";
													}

												}
												else
												{
													ss = ss + "erro escrever numero de parametros errado linha:" + Integer.toString(ll) + "\n";
												}
												break;
											case 0:
												break;
											case 3:
												if (temp1.length == 1)
												{

													program[ponteiroPro] = (byte) 0xbe;
													ponteiroPro++;
													int o = 0xff & (256 + (3 * 2));
													int oo = 0xff00 & (256 + (3 * 2));
													oo = oo >> 8;
													program[ponteiroPro] = (byte) o;
													ponteiroPro++;
													program[ponteiroPro] = (byte) oo;
													ponteiroPro++;
													program[ponteiroPro] = (byte) 0xff;
													ponteiroPro++;
													program[ponteiroPro] = (byte) 0xd6;
													ponteiroPro++;

												}
												else
												{
													ss = ss + "erro escrever numero de parametros errado linha:" + Integer.toString(ll) + "\n";
												}
												break;
											case 4:
												yw1 = 0;


												if (temp1.length == 3)
												{


													int yw2=0;

													for (int uuu=0;uuu < nome.size();uuu++)
													{

														if (nome.get(uuu).toString().compareToIgnoreCase(temp1[1].toString().trim()) == 0)
														{
															yw2 = uuu;
															ss = ss + "erro esta variavel ja foi defenida:" + temp1[1].toString().trim() + ";linha:" + Integer.toString(ll) + "\n";

															uuu = nome.size() + 100;
														}
													}
													nome.add(temp1[1].toString().trim());
													tipo.add(vtxt);
													endereco.add(ponteiroVar + 20000);

													int o1=Integer.parseInt(temp1[2].trim().replaceAll("-", ""));
													if (o1 > 32 * 1024 - 1 && o1 < 0)ss = ss + "erro numero entre:0 e" + Integer.toString(32 * 1024 - 1) + " :" + Integer.toString(ll) + "\n";
													int o=0xff & (o1);
													int oo=0xff00 & (o1);


													oo = oo >> 8;
													variaveis[ponteiroVar] = (byte) o;
													ponteiroVar++;
													variaveis[ponteiroVar] = (byte) oo;
													ponteiroVar++;








												}
												else
												{

													ss = ss + "erro variavel texto numero parametros linha:" + Integer.toString(ll) + "\n";
												}
												break;
											case 5:
												yw1 = 0;
												if (temp1.length == 3)
												{


													int yw2=-1;
													int yw3=0;

													for (int uuu=0;uuu < nome.size();uuu++)
													{

														if (nome.get(uuu).toString().compareToIgnoreCase(temp1[1].toString().trim()) == 0)
														{
															yw2 = uuu;
															uuu = nome.size() + 200;
														}
													}

													if (yw2 != -1)

													{

														program[ponteiroPro] = (byte) 0xbd;
														ponteiroPro++;
														int o=0xff & (endereco.get(yw2));
														int oo=0xff00 & (endereco.get(yw2));
														oo = oo >> 8;
														program[ponteiroPro] = (byte) o;
														ponteiroPro++;
														program[ponteiroPro] = (byte) oo;
														ponteiroPro++;
														yw2 = -1;
														for (int uuu=0;uuu < nome.size();uuu++)
														{

															if (nome.get(uuu).toString().compareToIgnoreCase(temp1[2].toString().trim()) == 0)
															{
																yw2 = uuu;
																uuu = nome.size() + 200;
															}
														}

														if (yw2 != -1)
														{


															program[ponteiroPro] = (byte) 0xb8;
															ponteiroPro++;
															o = 0xff & (endereco.get(yw2));
															oo = 0xff00 & (endereco.get(yw2));
															oo = oo >> 8;
															program[ponteiroPro] = (byte) o;
															ponteiroPro++;
															program[ponteiroPro] = (byte) oo;
															ponteiroPro++;

															program[ponteiroPro] = (byte) 0xbe;
															ponteiroPro++;
															o = 0xff & (256 + (3 * 3));
															oo = 0xff00 & (256 + (3 * 3));
															oo = oo >> 8;
															program[ponteiroPro] = (byte) o;
															ponteiroPro++;
															program[ponteiroPro] = (byte) oo;
															ponteiroPro++;
															program[ponteiroPro] = (byte) 0xff;
															ponteiroPro++;
															program[ponteiroPro] = (byte) 0xd6;
															ponteiroPro++;
														}
														else
														{
															ss = ss + "erro ler nome variavel indefinido errado linha:" + Integer.toString(ll) + "\n";
														}
													}
													else
													{
														ss = ss + "erro ler nome variavel indefinido errado linha:" + Integer.toString(ll) + "\n";
													}

												}
												else
												{
													ss = ss + "erro ler numero de parametros errado linha:" + Integer.toString(ll) + "\n";
												}
												break;
											case 6:
												if (temp1.length == 1)
												{
													program[ponteiroPro] = (byte) 0xc3;
													ponteiroPro++;
												}
												else
												{
													ss = ss + "erro ler numero de parametros errado linha:" + Integer.toString(ll) + "\n";
												}
												break;
											case 7:
												yw1 = 0;


												if (temp1.length == 2)
												{


													int yw2=-1;

													for (int uuu=0;uuu < nome.size();uuu++)
													{

														if (nome.get(uuu).toString().compareToIgnoreCase(temp1[1].toString().trim()) == 0)
														{
															yw2 = uuu;

															uuu = nome.size() + 100;
														}
													}
													if (yw2 == -1)
													{
														nome.add(temp1[1].toString().trim());
														tipo.add(vtxt);
														endereco.add(ponteiroVar + 20000);
														int o=0xff & (ponteiroPro + 10000);
														int oo=0xff00 & (ponteiroPro + 10000);
														oo = oo >> 8;
														variaveis[ponteiroVar] = (byte) o;
														ponteiroVar++;
														variaveis[ponteiroVar] = (byte) oo;
														ponteiroVar++;
													}
													else
													{
														int o=0xff & (ponteiroPro + 10000);
														int oo=0xff00 & (ponteiroPro + 10000);
														oo = oo >> 8;
														int iii=endereco.get(yw2) - 20000;
														variaveis[iii] = (byte)o;
														iii++;
														variaveis[iii] = (byte)oo;
														for (int uuu=0;uuu < nome.size();uuu++)
														{
															if (salto.size() > 0 && uuu < salto.size())
															{
																if (salto.get(uuu).toString().compareToIgnoreCase(temp1[1].toString().trim()) == 0)
																{

																	salto.remove(uuu);
																	posicao.remove(uuu);

																	if (uuu > 0)uuu--;
																	if (uuu > salto.size())uuu = salto.size() + 5000;

																}
															}
														}
													}

												}
												else
												{

													ss = ss + "erro variavel texto numero parametros linha:" + Integer.toString(ll) + "\n";
												}
												break;
											case 8:
												if (temp1.length == 2)
												{


													int yw2=-1;

													for (int uuu=0;uuu < nome.size();uuu++)
													{

														if (nome.get(uuu).toString().compareToIgnoreCase(temp1[1].toString().trim()) == 0)
														{
															yw2 = uuu;
															uuu = nome.size() + 200;
														}
													}
													if (yw2 == -1)
													{
														nome.add(temp1[1].toString().trim());
														tipo.add(vtxt);
														endereco.add(ponteiroVar + 20000);
														int o=0xff & (ponteiroPro + 10000);
														int oo=0xff00 & (ponteiroPro + 10000);
														oo = oo >> 8;
														variaveis[ponteiroVar] = (byte) 0;



														program[ponteiroPro] = (byte) 0xbd;
														ponteiroPro++;
														o = 0xff & (ponteiroVar + 20000);
													    oo = 0xff00 & (ponteiroVar + 20000);
														ponteiroVar++;
														variaveis[ponteiroVar] = (byte) 0;
														ponteiroVar++;
														oo = oo >> 8;
														program[ponteiroPro] = (byte) o;
														ponteiroPro++;
														program[ponteiroPro] = (byte) oo;
														ponteiroPro++;
														program[ponteiroPro] = (byte) 0x8b;
														ponteiroPro++;
														program[ponteiroPro] = (byte) 0x46;
														ponteiroPro++;
														program[ponteiroPro] = (byte) 0x0;
														ponteiroPro++;
														program[ponteiroPro] = (byte) 0xff;
														ponteiroPro++;
														program[ponteiroPro] = (byte) 0xe0;
														ponteiroPro++;
														salto.add(temp1[1].toString().trim());
														posicao.add(ll);
													}

													else
													{
														int iii=endereco.get(yw2);
														program[ponteiroPro] = (byte) 0xbd;
														ponteiroPro++;
														int o = 0xff & (iii);
													    int oo = 0xff00 & (iii);
														variaveis[ponteiroVar] = (byte) 0;
														ponteiroVar++;
														variaveis[ponteiroVar] = (byte) 0;
														ponteiroVar++;
														oo = oo >> 8;
														program[ponteiroPro] = (byte) o;
														ponteiroPro++;
														program[ponteiroPro] = (byte) oo;
														ponteiroPro++;
														program[ponteiroPro] = (byte) 0x8b;
														ponteiroPro++;
														program[ponteiroPro] = (byte) 0x46;
														ponteiroPro++;
														program[ponteiroPro] = (byte) 0x0;
														ponteiroPro++;
														program[ponteiroPro] = (byte) 0xff;
														ponteiroPro++;
														program[ponteiroPro] = (byte) 0xe0;
														ponteiroPro++;

													}


												}
												else
												{
													ss = ss + "erro escrever numero de parametros errado linha:" + Integer.toString(ll) + "\n";
												}
												break;
											case 9:
												yw1 = 0;


												if (temp1.length > 2)
												{


													int yw2=-1;

													for (int uuu=0;uuu < nome.size();uuu++)
													{

														if (nome.get(uuu).toString().compareToIgnoreCase(temp1[1].toString().trim()) == 0)
														{
															yw2 = uuu;
															ss = ss + "erro esta variavel ja foi defenida:"  + temp1[1].toString().trim() + ";linha:" + Integer.toString(ll) + "\n";
															uuu = nome.size() + 100;
														}
													}
													nome.add(temp1[1].toString().trim());
													tipo.add(vtxt);
													endereco.add(ponteiroVar + 20000);
													int o=0xff & (ponteiroTxt + 30000);
													int oo=0xff00 & (ponteiroTxt + 30000);
													oo = oo >> 8;
													variaveis[ponteiroVar] = (byte) o;
													ponteiroVar++;
													variaveis[ponteiroVar] = (byte) oo;
													ponteiroVar++;

													for (int ttt=2;ttt < temp1.length;ttt++)
													{
														int y=Integer.parseInt(temp1[ttt]);
														o = 0xff & (y);

														textos[ponteiroTxt] = (byte)o;
														ponteiroTxt++;





													}





													textos[ponteiroTxt] = (byte) 0xc3;
													ponteiroTxt++;
												}
												else
												{

													ss = ss + "erro variavel texto numero parametros linha:" + Integer.toString(ll) + "\n";
												}
												break;
											case 10:
												if (temp1.length == 2)
												{


													int yw2=-1;

													for (int uuu=0;uuu < nome.size();uuu++)
													{

														if (nome.get(uuu).toString().compareToIgnoreCase(temp1[1].toString().trim()) == 0)
														{
															yw2 = uuu;
															uuu = nome.size() + 200;
														}
													}
													if (yw2 == -1)
													{
														nome.add(temp1[1].toString().trim());
														tipo.add(vtxt);
														endereco.add(ponteiroVar + 20000);
														int o=0xff & (ponteiroPro + 10000);
														int oo=0xff00 & (ponteiroPro + 10000);
														oo = oo >> 8;
														variaveis[ponteiroVar] = (byte) 0;



														program[ponteiroPro] = (byte) 0xbd;
														ponteiroPro++;
														o = 0xff & (ponteiroVar + 20000);
													    oo = 0xff00 & (ponteiroVar + 20000);
														ponteiroVar++;
														variaveis[ponteiroVar] = (byte) 0;
														ponteiroVar++;
														oo = oo >> 8;
														program[ponteiroPro] = (byte) o;
														ponteiroPro++;
														program[ponteiroPro] = (byte) oo;
														ponteiroPro++;
														program[ponteiroPro] = (byte) 0x8b;
														ponteiroPro++;
														program[ponteiroPro] = (byte) 0x46;
														ponteiroPro++;
														program[ponteiroPro] = (byte) 0x0;
														ponteiroPro++;
														program[ponteiroPro] = (byte) 0xff;
														ponteiroPro++;
														program[ponteiroPro] = (byte) 0xd0;
														ponteiroPro++;
														salto.add(temp1[1].toString().trim());
														posicao.add(ll);
													}

													else
													{
														int iii=endereco.get(yw2);
														program[ponteiroPro] = (byte) 0xbd;
														ponteiroPro++;
														int o = 0xff & (iii);
													    int oo = 0xff00 & (iii);
														variaveis[ponteiroVar] = (byte) 0;
														ponteiroVar++;
														variaveis[ponteiroVar] = (byte) 0;
														ponteiroVar++;
														oo = oo >> 8;
														program[ponteiroPro] = (byte) o;
														ponteiroPro++;
														program[ponteiroPro] = (byte) oo;
														ponteiroPro++;
														program[ponteiroPro] = (byte) 0x8b;
														ponteiroPro++;
														program[ponteiroPro] = (byte) 0x46;
														ponteiroPro++;
														program[ponteiroPro] = (byte) 0x0;
														ponteiroPro++;
														program[ponteiroPro] = (byte) 0xff;
														ponteiroPro++;
														program[ponteiroPro] = (byte) 0xe0;
														ponteiroPro++;

													}


												}
												else
												{
													ss = ss + "erro escrever numero de parametros errado linha:" + Integer.toString(ll) + "\n";
												}
												break;
											case 11:
												if (temp1.length == 1)
												{
													program[ponteiroPro] = (byte) 0xcd;
													ponteiroPro++;
													program[ponteiroPro] = (byte) 0x20;
													ponteiroPro++;
												}
												else
												{
													ss = ss + "erro ler numero de parametros errado linha:" + Integer.toString(ll) + "\n";
												}
												break;
											case 12:
												if (temp1.length == 3)
												{

													int add=0;
													int yw2=-1;
													int yw22=-1;

													for (int uuu=0;uuu < nome.size();uuu++)
													{

														if (nome.get(uuu).toString().compareToIgnoreCase(temp1[2].toString().trim()) == 0)
														{
															yw2 = uuu;
															uuu = nome.size() + 200;
														}
													}
													for (int uuu=0;uuu < nome.size();uuu++)
													{

														if (nome.get(uuu).toString().compareToIgnoreCase(temp1[1].toString().trim()) == 0)
														{
															yw22 = uuu;
															add = endereco.get(uuu);
															uuu = nome.size() + 200;
														}
													}



													if (yw22 != -1)
													{
														if (yw2 == -1)
														{
															nome.add(temp1[2].toString().trim());
															tipo.add(vtxt);
															endereco.add(ponteiroVar + 20000);
															int o=0xff & (ponteiroPro + 10000);
															int oo=0xff00 & (ponteiroPro + 10000);
															oo = oo >> 8;
															variaveis[ponteiroVar] = (byte) 0;



															program[ponteiroPro] = (byte) 0xbd;
															ponteiroPro++;
															o = 0xff & (ponteiroVar + 20000);
															oo = 0xff00 & (ponteiroVar + 20000);
															ponteiroVar++;
															variaveis[ponteiroVar] = (byte) 0;
															ponteiroVar++;
															oo = oo >> 8;
															program[ponteiroPro] = (byte) o;
															ponteiroPro++;
															program[ponteiroPro] = (byte) oo;
															ponteiroPro++;
															program[ponteiroPro] = (byte) 0x8b;
															ponteiroPro++;
															program[ponteiroPro] = (byte) 0x46;
															ponteiroPro++;
															program[ponteiroPro] = (byte) 0x0;
															ponteiroPro++;
															o = 0xff & (add);
															oo = 0xff00 & (add);
															oo = oo >> 8;
															program[ponteiroPro] = (byte) 0xbd;
															ponteiroPro++;
															program[ponteiroPro] = (byte) o;
															ponteiroPro++;
															program[ponteiroPro] = (byte) oo;
															ponteiroPro++;

															program[ponteiroPro] = (byte) 0x8b;
															ponteiroPro++;

															program[ponteiroPro] = (byte) 0x4e;
															ponteiroPro++;

															program[ponteiroPro] = (byte) 0;
															ponteiroPro++;

															program[ponteiroPro] = (byte) 0x83;
															ponteiroPro++;

															program[ponteiroPro] = (byte) 0xf9;
															ponteiroPro++;

															program[ponteiroPro] = (byte) 0x0;
															ponteiroPro++;

															program[ponteiroPro] = (byte) 0x74;
															ponteiroPro++;

															program[ponteiroPro] = (byte) 0x2;
															ponteiroPro++;

															program[ponteiroPro] = (byte) 0xff;
															ponteiroPro++;

															program[ponteiroPro] = (byte) 0xe0;
															ponteiroPro++;

															




															
															salto.add(temp1[2].toString().trim());
															posicao.add(ll);
														}

														else
														{
															int iii=endereco.get(yw2);
															program[ponteiroPro] = (byte) 0xbd;
															ponteiroPro++;
															int o = 0xff & (iii);
															int oo = 0xff00 & (iii);
															variaveis[ponteiroVar] = (byte) 0;
															ponteiroVar++;
															variaveis[ponteiroVar] = (byte) 0;

															ponteiroVar++;

															oo = oo >> 8;
															program[ponteiroPro] = (byte) o;
															ponteiroPro++;
															program[ponteiroPro] = (byte) oo;
															ponteiroPro++;
															program[ponteiroPro] = (byte) 0x8b;
															ponteiroPro++;
															program[ponteiroPro] = (byte) 0x46;
															ponteiroPro++;
															program[ponteiroPro] = (byte) 0x0;
															ponteiroPro++;

															o = 0xff & (add);
															oo = 0xff00 & (add);
															oo = oo >> 8;
															program[ponteiroPro] = (byte) 0xbd;
															ponteiroPro++;
															program[ponteiroPro] = (byte) o;
															ponteiroPro++;
															program[ponteiroPro] = (byte) oo;
															ponteiroPro++;

															

															program[ponteiroPro] = (byte) 0x8b;
															ponteiroPro++;

															program[ponteiroPro] = (byte) 0x4e;
															ponteiroPro++;

															program[ponteiroPro] = (byte) 0x0;
															ponteiroPro++;

															

															program[ponteiroPro] = (byte) 0x83;
															ponteiroPro++;

															program[ponteiroPro] = (byte) 0xf9;
															ponteiroPro++;

															program[ponteiroPro] = (byte) 0x0;
															ponteiroPro++;

															program[ponteiroPro] = (byte) 0x74;
															ponteiroPro++;

															program[ponteiroPro] = (byte) 0x2;
															ponteiroPro++;

															program[ponteiroPro] = (byte) 0xff;
															ponteiroPro++;

															program[ponteiroPro] = (byte) 0xe0;
															ponteiroPro++;

															

															

														}
													}

													else
													{

														ss = ss + "erro variavel texto numero parametros linha:" + Integer.toString(ll) + "\n";
													}

												}
												else
												{
													ss = ss + "erro escrever numero de parametros errado linha:" + Integer.toString(ll) + "\n";
												}
												break;
											case 13:
												if (temp1.length == 3)
												{

													int add=0;
													int add2=0;
													int yw2=-1;
													int yw22=-1;

													for (int uuu=0;uuu < nome.size();uuu++)
													{

														if (nome.get(uuu).toString().compareToIgnoreCase(temp1[1].toString().trim()) == 0)
														{
															yw2 = uuu;
															add = endereco.get(uuu);
															uuu = nome.size() + 200;
														}
													}
													for (int uuu=0;uuu < nome.size();uuu++)
													{

														if (nome.get(uuu).toString().compareToIgnoreCase(temp1[2].toString().trim()) == 0)
														{
															yw22 = uuu;
															add2 = endereco.get(uuu);
															uuu = nome.size() + 200;
														}
													}



													if (yw22 != -1 && yw2 != -1)
													{

														program[ponteiroPro] = (byte) 0xbd;
														ponteiroPro++;


														int o=0xff & (add2);
														int oo=0xff00 & (add2);
														oo = oo >> 8;
														program[ponteiroPro] = (byte) o;
														ponteiroPro++;
														program[ponteiroPro] = (byte) oo;
														ponteiroPro++;

														program[ponteiroPro] = (byte) 0x8b;
														ponteiroPro++;

														program[ponteiroPro] = (byte) 0x46;
														ponteiroPro++;

														program[ponteiroPro] = (byte) 0x0;
														ponteiroPro++;

														program[ponteiroPro] = (byte) 0xbd;
														ponteiroPro++;

														o = 0xff & (add);
														oo = 0xff00 & (add);
														oo = oo >> 8;
														program[ponteiroPro] = (byte) o;
														ponteiroPro++;
														program[ponteiroPro] = (byte) oo;
														ponteiroPro++;

														program[ponteiroPro] = (byte) 0x8b;
														ponteiroPro++;

														program[ponteiroPro] = (byte) 0x5e;
														ponteiroPro++;

														program[ponteiroPro] = (byte) 0x0;
														ponteiroPro++;

														program[ponteiroPro] = (byte) 0xf8;
														ponteiroPro++;

														program[ponteiroPro] = (byte) 0x1;
														ponteiroPro++;
														program[ponteiroPro] = (byte) 0xd8;
														ponteiroPro++;

														program[ponteiroPro] = (byte) 0x89;
														ponteiroPro++;

														program[ponteiroPro] = (byte) 0x46;
														ponteiroPro++;

														program[ponteiroPro] = (byte) 0x0;
														ponteiroPro++;

													}



													else
													{

														ss = ss + "erro variavel texto numero parametros linha:" + Integer.toString(ll) + "\n";
													}

												}
												else
												{
													ss = ss + "erro escrever numero de parametros errado linha:" + Integer.toString(ll) + "\n";
												}
												break;
											case 14:
												if (temp1.length == 4)
												{

													int add=0;
													int add2=0;
													int add3=0;
													int yw2=-1;
													int yw22=-1;
													int yw222=-1;

													for (int uuu=0;uuu < nome.size();uuu++)
													{

														if (nome.get(uuu).toString().compareToIgnoreCase(temp1[1].toString().trim()) == 0)
														{
															yw2 = uuu;
															add = endereco.get(uuu);
															uuu = nome.size() + 200;
														}
													}
													for (int uuu=0;uuu < nome.size();uuu++)
													{

														if (nome.get(uuu).toString().compareToIgnoreCase(temp1[2].toString().trim()) == 0)
														{
															yw22 = uuu;
															add2 = endereco.get(uuu);
															uuu = nome.size() + 200;
														}
													}

													for (int uuu=0;uuu < nome.size();uuu++)
													{

														if (nome.get(uuu).toString().compareToIgnoreCase(temp1[3].toString().trim()) == 0)
														{
															yw222 = uuu;
															add3 = endereco.get(uuu);
															uuu = nome.size() + 200;
														}
													}

													if (yw22 != -1 && yw2 != -1 && yw222 != -1)
													{

														program[ponteiroPro] = (byte) 0xbd;
														ponteiroPro++;


														int o=0xff & (add2);
														int oo=0xff00 & (add2);
														oo = oo >> 8;
														program[ponteiroPro] = (byte) o;
														ponteiroPro++;
														program[ponteiroPro] = (byte) oo;
														ponteiroPro++;


														program[ponteiroPro] = (byte) 0xba;
														ponteiroPro++;


														o = 0xff & (add3);
														oo = 0xff00 & (add3);
														oo = oo >> 8;
														program[ponteiroPro] = (byte) o;
														ponteiroPro++;
														program[ponteiroPro] = (byte) oo;
														ponteiroPro++;



														program[ponteiroPro] = (byte) 0xb9;
														ponteiroPro++;


														o = 0xff & (add);
														oo = 0xff00 & (add);
														oo = oo >> 8;
														program[ponteiroPro] = (byte) o;
														ponteiroPro++;
														program[ponteiroPro] = (byte) oo;
														ponteiroPro++;


														program[ponteiroPro] = (byte) 0xbe;
														ponteiroPro++;

														o = 0xff & (256 + (3 * 4));
														oo = 0xff00 & (256 + (3 * 4));
														oo = oo >> 8;
														program[ponteiroPro] = (byte) o;
														ponteiroPro++;
														program[ponteiroPro] = (byte) oo;
														ponteiroPro++;

														program[ponteiroPro] = (byte) 0xff;
														ponteiroPro++;
														program[ponteiroPro] = (byte) 0xd6;
														ponteiroPro++;


													}



													else
													{

														ss = ss + "erro variavel texto numero parametros linha:" + Integer.toString(ll) + "\n";
													}

												}
												else
												{
													ss = ss + "erro escrever numero de parametros errado linha:" + Integer.toString(ll) + "\n";
												}
												break;
											case 15:
												if (temp1.length == 1)
												{

													int add=0;
													int add2=0;
													int add3=0;
													int yw2=-1;
													int yw22=-1;
													int yw222=-1;








													program[ponteiroPro] = (byte) 0xbe;
													ponteiroPro++;

													int o = 0xff & (256 + (3 * 5));
													int oo = 0xff00 & (256 + (3 * 5));
													oo = oo >> 8;
													program[ponteiroPro] = (byte) o;
													ponteiroPro++;
													program[ponteiroPro] = (byte) oo;
													ponteiroPro++;

													program[ponteiroPro] = (byte) 0xff;
													ponteiroPro++;
													program[ponteiroPro] = (byte) 0xd6;
													ponteiroPro++;







												}
												else
												{
													ss = ss + "erro escrever numero de parametros errado linha:" + Integer.toString(ll) + "\n";
												}
												break;
											case 16:
												if (temp1.length == 6)
												{

													int add=0;
													int add2=0;
													int add3=0;
													int add4=0;
													int add5=0;
													int yw2=-1;
													int yw22=-1;
													int yw222=-1;
													int yw2222=-1;
													int yw22222=-1;

													for (int uuu=0;uuu < nome.size();uuu++)
													{

														if (nome.get(uuu).toString().compareToIgnoreCase(temp1[1].toString().trim()) == 0)
														{
															yw2 = uuu;
															add = endereco.get(uuu);
															uuu = nome.size() + 200;
														}
													}
													for (int uuu=0;uuu < nome.size();uuu++)
													{

														if (nome.get(uuu).toString().compareToIgnoreCase(temp1[2].toString().trim()) == 0)
														{
															yw22 = uuu;
															add2 = endereco.get(uuu);
															uuu = nome.size() + 200;
														}
													}

													for (int uuu=0;uuu < nome.size();uuu++)
													{

														if (nome.get(uuu).toString().compareToIgnoreCase(temp1[3].toString().trim()) == 0)
														{
															yw222 = uuu;
															add3 = endereco.get(uuu);
															uuu = nome.size() + 200;
														}
													}



													for (int uuu=0;uuu < nome.size();uuu++)
													{

														if (nome.get(uuu).toString().compareToIgnoreCase(temp1[4].toString().trim()) == 0)
														{
															yw2222 = uuu;
															add4 = endereco.get(uuu);
															uuu = nome.size() + 200;
														}
													}

													for (int uuu=0;uuu < nome.size();uuu++)
													{

														if (nome.get(uuu).toString().compareToIgnoreCase(temp1[5].toString().trim()) == 0)
														{
															yw22222 = uuu;
															add5 = endereco.get(uuu);
															uuu = nome.size() + 200;
														}
													}

													if (yw22 != -1 && yw2 != -1 && yw222 != -1 && yw2222 != -1 && yw22222 != -1)
													{

														program[ponteiroPro] = (byte) 0xbe;
														ponteiroPro++;


														int o=0xff & (add);
														int oo=0xff00 & (add);
														oo = oo >> 8;
														program[ponteiroPro] = (byte) o;
														ponteiroPro++;
														program[ponteiroPro] = (byte) oo;
														ponteiroPro++;

														program[ponteiroPro] = (byte) 0x8b;
														ponteiroPro++;
														program[ponteiroPro] = (byte) 0x4;
														ponteiroPro++;


														program[ponteiroPro] = (byte) 0xbe;
														ponteiroPro++;


														o = 0xff & (add2);
														oo = 0xff00 & (add2);
														oo = oo >> 8;
														program[ponteiroPro] = (byte) o;
														ponteiroPro++;
														program[ponteiroPro] = (byte) oo;
														ponteiroPro++;


														program[ponteiroPro] = (byte) 0x8b;
														ponteiroPro++;
														program[ponteiroPro] = (byte) 0x1c;
														ponteiroPro++;



														program[ponteiroPro] = (byte) 0xbe;
														ponteiroPro++;


														o = 0xff & (add3);
														oo = 0xff00 & (add3);
														oo = oo >> 8;
														program[ponteiroPro] = (byte) o;
														ponteiroPro++;
														program[ponteiroPro] = (byte) oo;
														ponteiroPro++;



														program[ponteiroPro] = (byte) 0x8b;
														ponteiroPro++;
														program[ponteiroPro] = (byte) 0x14;
														ponteiroPro++;


														program[ponteiroPro] = (byte) 0xbe;
														ponteiroPro++;


														o = 0xff & (add4);
														oo = 0xff00 & (add4);
														oo = oo >> 8;
														program[ponteiroPro] = (byte) o;
														ponteiroPro++;
														program[ponteiroPro] = (byte) oo;
														ponteiroPro++;

														program[ponteiroPro] = (byte) 0x8b;
														ponteiroPro++;
														program[ponteiroPro] = (byte) 0x2c;
														ponteiroPro++;


														program[ponteiroPro] = (byte) 0xbe;
														ponteiroPro++;


														o = 0xff & (add5);
														oo = 0xff00 & (add5);
														oo = oo >> 8;
														program[ponteiroPro] = (byte) o;
														ponteiroPro++;
														program[ponteiroPro] = (byte) oo;
														ponteiroPro++;

														program[ponteiroPro] = (byte) 0x8b;
														ponteiroPro++;
														program[ponteiroPro] = (byte) 0xc;
														ponteiroPro++;


														program[ponteiroPro] = (byte) 0xbe;
														ponteiroPro++;

														o = 0xff & (256 + (3 * 6));
														oo = 0xff00 & (256 + (3 * 6));
														oo = oo >> 8;
														program[ponteiroPro] = (byte) o;
														ponteiroPro++;
														program[ponteiroPro] = (byte) oo;
														ponteiroPro++;



														program[ponteiroPro] = (byte) 0xff;
														ponteiroPro++;
														program[ponteiroPro] = (byte) 0xd6;
														ponteiroPro++;


													}



													else
													{

														ss = ss + "erro variavel texto numero parametros linha:" + Integer.toString(ll) + "\n";
													}

												}
												else
												{
													ss = ss + "erro escrever numero de parametros errado linha:" + Integer.toString(ll) + "\n";
												}

												break;
											case 17:
												if (temp1.length == 3)
												{

													int add=0;
													int add2=0;
													int yw2=-1;
													int yw22=-1;

													for (int uuu=0;uuu < nome.size();uuu++)
													{

														if (nome.get(uuu).toString().compareToIgnoreCase(temp1[1].toString().trim()) == 0)
														{
															yw2 = uuu;
															add = endereco.get(uuu);
															uuu = nome.size() + 200;
														}
													}

													add2 = Integer.parseInt(temp1[2].toString().trim());







													if (yw2 != -1)
													{

														program[ponteiroPro] = (byte) 0xbd;
														ponteiroPro++;


														int o=0xff & (add);
														int oo=0xff00 & (add);
														oo = oo >> 8;
														program[ponteiroPro] = (byte) o;
														ponteiroPro++;
														program[ponteiroPro] = (byte) oo;
														ponteiroPro++;

														program[ponteiroPro] = (byte) 0xb8;
														ponteiroPro++;


														o = 0xff & (add2);
														oo = 0xff00 & (add2);
														oo = oo >> 8;
														program[ponteiroPro] = (byte) o;
														ponteiroPro++;
														program[ponteiroPro] = (byte) oo;
														ponteiroPro++;

														program[ponteiroPro] = (byte) 0x89;
														ponteiroPro++;

														program[ponteiroPro] = (byte) 0x46;
														ponteiroPro++;

														program[ponteiroPro] = (byte) 0x0;
														ponteiroPro++;

													}



													else
													{

														ss = ss + "erro variavel texto numero parametros linha:" + Integer.toString(ll) + "\n";
													}

												}
												else
												{
													ss = ss + "erro escrever numero de parametros errado linha:" + Integer.toString(ll) + "\n";
												}
												break;
											case 18:
												if (temp1.length == 3)
												{

													int add=0;
													int add2=0;
													int yw2=-1;
													int yw22=-1;

													for (int uuu=0;uuu < nome.size();uuu++)
													{

														if (nome.get(uuu).toString().compareToIgnoreCase(temp1[1].toString().trim()) == 0)
														{
															yw2 = uuu;
															add = endereco.get(uuu);
															uuu = nome.size() + 200;
														}
													}
													for (int uuu=0;uuu < nome.size();uuu++)
													{

														if (nome.get(uuu).toString().compareToIgnoreCase(temp1[2].toString().trim()) == 0)
														{
															yw22 = uuu;
															add2 = endereco.get(uuu);
															uuu = nome.size() + 200;
														}
													}



													if (yw22 != -1 && yw2 != -1)
													{

														program[ponteiroPro] = (byte) 0xbd;
														ponteiroPro++;


														int o=0xff & (add2);
														int oo=0xff00 & (add2);
														oo = oo >> 8;
														program[ponteiroPro] = (byte) o;
														ponteiroPro++;
														program[ponteiroPro] = (byte) oo;
														ponteiroPro++;

														program[ponteiroPro] = (byte) 0x8b;
														ponteiroPro++;
														program[ponteiroPro] = (byte) 0x46;
														ponteiroPro++;
														program[ponteiroPro] = (byte) 0x0;
														ponteiroPro++;

														program[ponteiroPro] = (byte) 0xbd;
														ponteiroPro++;


														o = 0xff & (add);
														oo = 0xff00 & (add);
														oo = oo >> 8;
														program[ponteiroPro] = (byte) o;
														ponteiroPro++;
														program[ponteiroPro] = (byte) oo;
														ponteiroPro++;


														program[ponteiroPro] = (byte) 0x89;
														ponteiroPro++;
														program[ponteiroPro] = (byte) 0x46;
														ponteiroPro++;
														program[ponteiroPro] = (byte) 0x0;
														ponteiroPro++;

													}



													else
													{

														ss = ss + "erro variavel texto numero parametros linha:" + Integer.toString(ll) + "\n";
													}

												}
												else
												{
													ss = ss + "erro escrever numero de parametros errado linha:" + Integer.toString(ll) + "\n";
												}
												break;
											case 19:
												yw1 = 0;


												if (temp1.length == 5)
												{


													int yw2=-1;

													for (int uuu=0;uuu < nome.size();uuu++)
													{

														if (nome.get(uuu).toString().compareToIgnoreCase(temp1[1].toString().trim()) == 0)
														{
															yw2 = uuu;
															ss = ss + "erro esta variavel ja foi defenida:"  + temp1[1].toString().trim() + ";linha:" + Integer.toString(ll) + "\n";
															uuu = nome.size() + 100;
														}
													}
													nome.add(temp1[1].toString().trim());
													tipo.add(vtxt);
													endereco.add(ponteiroVar + 20000);
													int o1=0xff & (ponteiroVar + 20000);
													int oo1=0xff00 & (ponteiroVar + 20000);
													oo1 = oo1 >> 8;


													int o=0xff & (Integer.parseInt(temp1[2].trim()));
													int oo=0xff00 & (Integer.parseInt(temp1[2].trim()));
													oo = oo >> 8;
													variaveis[ponteiroVar] = (byte)o ;
													ponteiroVar++;
													variaveis[ponteiroVar] = (byte) oo;
													ponteiroVar++;

													int o11=0xff & (ponteiroVar + 20000);
													int oo11=0xff00 & (ponteiroVar + 20000);
													oo11 = oo11 >> 8;
													variaveis[ponteiroVar] = (byte)o ;
													ponteiroVar++;
													variaveis[ponteiroVar] = (byte) oo;
													ponteiroVar++;


													o = 0xff & (Integer.parseInt(temp1[3].trim()));
													oo = 0xff00 & (Integer.parseInt(temp1[3].trim()));
													oo = oo >> 8;
													variaveis[ponteiroVar] = (byte)o ;
													ponteiroVar++;
													variaveis[ponteiroVar] = (byte) oo;
													ponteiroVar++;
													o = 0xff & (Integer.parseInt(temp1[4].trim()));
													oo = 0xff00 & (Integer.parseInt(temp1[4].trim()));
													oo = oo >> 8;
													variaveis[ponteiroVar] = (byte)o ;
													ponteiroVar++;
													variaveis[ponteiroVar] = (byte) oo;
													ponteiroVar++;

													program[ponteiroPro] = (byte) 0xbd;
													ponteiroPro++;

													program[ponteiroPro] = (byte) o11;
													ponteiroPro++;
													program[ponteiroPro] = (byte) oo11;
													ponteiroPro++;

													program[ponteiroPro] = (byte) 0x8b;
													ponteiroPro++;

													program[ponteiroPro] = (byte) 0x46;
													ponteiroPro++;

													program[ponteiroPro] = (byte) 0x0;
													ponteiroPro++;


													program[ponteiroPro] = (byte) 0xbd;
													ponteiroPro++;

													program[ponteiroPro] = (byte) o1;
													ponteiroPro++;
													program[ponteiroPro] = (byte) oo1;
													ponteiroPro++;

													program[ponteiroPro] = (byte) 0x89;
													ponteiroPro++;

													program[ponteiroPro] = (byte) 0x46;
													ponteiroPro++;

													program[ponteiroPro] = (byte) 0x0;
													ponteiroPro++;

													nome.add("de" + temp1[1].toString().trim() + "2016");
													tipo.add(vtxt);
													endereco.add(ponteiroPro + 10000);


												}
												else
												{

													ss = ss + "erro variavel texto numero parametros linha:" + Integer.toString(ll) + "\n";
												}
												break;
											case 20:
												yw1 = 0;
												if (temp1.length == 2)
												{


													int yw2=-1;
													int yw3=0;

													for (int uuu=0;uuu < nome.size();uuu++)
													{

														if (nome.get(uuu).toString().compareToIgnoreCase(temp1[1].toString().trim()) == 0)
														{
															yw2 = uuu;
															uuu = nome.size() + 200;
														}
													}

													if (yw2 != -1)

													{


														int o=0xff & (endereco.get(yw2));
														int oo=0xff00 & (endereco.get(yw2));
														oo = oo >> 8;

														int o1=0xff & (endereco.get(yw2) + 2);
														int oo1=0xff00 & (endereco.get(yw2) + 2);
														oo1 = oo >> 8;

														int o2=0xff & (endereco.get(yw2) + 4);
														int oo2=0xff00 & (endereco.get(yw2) + 4);
														oo2 = oo2 >> 8;
														int o3=0xff & (endereco.get(yw2) + 6);
														int oo3=0xff00 & (endereco.get(yw2) + 6);
														oo3 = oo3 >> 8;

														program[ponteiroPro] = (byte) 0x66;
														ponteiroPro++;

														program[ponteiroPro] = (byte) 0x31;
														ponteiroPro++;


														program[ponteiroPro] = (byte) 0xc0;
														ponteiroPro++;


														program[ponteiroPro] = (byte) 0x66;
														ponteiroPro++;

														program[ponteiroPro] = (byte) 0x31;
														ponteiroPro++;


														program[ponteiroPro] = (byte) 0xc9;
														ponteiroPro++;

														program[ponteiroPro] = (byte) 0xbd;
														ponteiroPro++;

														program[ponteiroPro] = (byte) o;
														ponteiroPro++;


														program[ponteiroPro] = (byte) oo;
														ponteiroPro++;




														program[ponteiroPro] = (byte) 0x8b;
														ponteiroPro++;

														program[ponteiroPro] = (byte) 0x46;
														ponteiroPro++;


														program[ponteiroPro] = (byte) 0x0;
														ponteiroPro++;


														program[ponteiroPro] = (byte) 0xbd;
														ponteiroPro++;

														program[ponteiroPro] = (byte) o3;
														ponteiroPro++;


														program[ponteiroPro] = (byte) oo3;
														ponteiroPro++;

														program[ponteiroPro] = (byte) 0x8b;
														ponteiroPro++;

														program[ponteiroPro] = (byte) 0x5e;
														ponteiroPro++;


														program[ponteiroPro] = (byte) 0x0;
														ponteiroPro++;


														program[ponteiroPro] = (byte) 0xf8;
														ponteiroPro++;

														program[ponteiroPro] = (byte) 0x1;
														ponteiroPro++;


														program[ponteiroPro] = (byte) 0xd8;
														ponteiroPro++;


														program[ponteiroPro] = (byte) 0xbd;
														ponteiroPro++;

														program[ponteiroPro] = (byte) o;
														ponteiroPro++;


														program[ponteiroPro] = (byte) oo;
														ponteiroPro++;


														program[ponteiroPro] = (byte) 0x89;
														ponteiroPro++;

														program[ponteiroPro] = (byte) 0x46;
														ponteiroPro++;


														program[ponteiroPro] = (byte) 0x0;
														ponteiroPro++;

														program[ponteiroPro] = (byte) 0xbd;
														ponteiroPro++;

														program[ponteiroPro] = (byte) o2;
														ponteiroPro++;


														program[ponteiroPro] = (byte) oo2;
														ponteiroPro++;


														program[ponteiroPro] = (byte) 0x8b;
														ponteiroPro++;

														program[ponteiroPro] = (byte) 0x4e;
														ponteiroPro++;


														program[ponteiroPro] = (byte) 0x0;
														ponteiroPro++;


														program[ponteiroPro] = (byte) 0x66;
														ponteiroPro++;

														program[ponteiroPro] = (byte) 0x39;
														ponteiroPro++;


														program[ponteiroPro] = (byte) 0xc8;
														ponteiroPro++;

														program[ponteiroPro] = (byte) 0x77;
														ponteiroPro++;

														program[ponteiroPro] = (byte) 0x5;
														ponteiroPro++;










														yw2 = -1;
														for (int uuu=0;uuu < nome.size();uuu++)
														{

															if (nome.get(uuu).toString().compareToIgnoreCase("de" + temp1[1].toString().trim() + "2016") == 0)
															{
																yw2 = uuu;
																uuu = nome.size() + 200;
															}
														}

														if (yw2 != -1)
														{


															program[ponteiroPro] = (byte) 0xbe;
															ponteiroPro++;
															o = 0xff & (endereco.get(yw2));
															oo = 0xff00 & (endereco.get(yw2));
															oo = oo >> 8;
															program[ponteiroPro] = (byte) o;
															ponteiroPro++;

															program[ponteiroPro] = (byte) oo;
															ponteiroPro++;


															program[ponteiroPro] = (byte) 0xff;
															ponteiroPro++;


															program[ponteiroPro] = (byte) 0xe6;
															ponteiroPro++;

														}
														else
														{
															ss = ss + "erro ler nome variavel indefinido errado linha:" + Integer.toString(ll) + "\n";
														}
													}
													else
													{
														ss = ss + "erro ler nome variavel indefinido errado linha:" + Integer.toString(ll) + "\n";
													}

												}
												else
												{
													ss = ss + "erro ler numero de parametros errado linha:" + Integer.toString(ll) + "\n";
												}
												break;
											case 21:
												yw1 = 0;


												if (temp1.length == 5)
												{

													int add=0;
													int add2=0;
													int add3=0;
													int add4=0;
													int add5=0;
													int yw2=-1;
													int yw22=-1;
													int yw222=-1;
													int yw2222=-1;
													int yw22222=-1;

													for (int uuu=0;uuu < nome.size();uuu++)
													{

														if (nome.get(uuu).toString().compareToIgnoreCase(temp1[1].toString().trim()) == 0)
														{
															yw2 = uuu;
															add = endereco.get(uuu);
															uuu = nome.size() + 200;
															
														}
													}
													for (int uuu=0;uuu < nome.size();uuu++)
													{

														if (nome.get(uuu).toString().compareToIgnoreCase(temp1[2].toString().trim()) == 0)
														{
															yw22 = uuu;
															add2 = endereco.get(uuu);
															uuu = nome.size() + 200;
														}
													}

													for (int uuu=0;uuu < nome.size();uuu++)
													{

														if (nome.get(uuu).toString().compareToIgnoreCase(temp1[3].toString().trim()) == 0)
														{
															yw222 = uuu;
															add3 = endereco.get(uuu);
															uuu = nome.size() + 200;
														}
													}



													for (int uuu=0;uuu < nome.size();uuu++)
													{

														if (nome.get(uuu).toString().compareToIgnoreCase(temp1[4].toString().trim()) == 0)
														{
															yw2222 = uuu;
															add4 = endereco.get(uuu);
															uuu = nome.size() + 200;
														}
													}

										
													if (yw22 != -1 && yw222 != -1 && yw2222 != -1)
													{

														nome.add(temp1[1].toString().trim());
														tipo.add(vtxt);
														endereco.add(ponteiroVar + 20000);
														int o1=0xff & (ponteiroVar + 20000);
														int oo1=0xff00 & (ponteiroVar + 20000);
														oo1 = oo1 >> 8;
														variaveis[ponteiroVar] = (byte)0 ;
														ponteiroVar++;
														variaveis[ponteiroVar] = (byte)0 ;
														ponteiroVar++;
														

														int o=0xff & (add2);
														int oo=0xff00 & (add2);
														
														oo = oo >> 8;
														variaveis[ponteiroVar] = (byte)o ;
														ponteiroVar++;
														variaveis[ponteiroVar] = (byte) oo;
														ponteiroVar++;


														o=0xff & (add3);
														oo=0xff00 & (add3);
														oo = oo >> 8;
														
														variaveis[ponteiroVar] = (byte)o ;
														ponteiroVar++;
														variaveis[ponteiroVar] = (byte) oo;
														ponteiroVar++;
														

														 o=0xff & (add4);
														 oo=0xff00 & (add4);
														oo = oo >> 8;
													
														variaveis[ponteiroVar] = (byte)o ;
														ponteiroVar++;
														variaveis[ponteiroVar] = (byte) oo;
														ponteiroVar++;
														
														

														 
														
														

														program[ponteiroPro] = (byte) 0xbd;
														ponteiroPro++;

														program[ponteiroPro] = (byte) o1;
														ponteiroPro++;
														program[ponteiroPro] = (byte) oo1;
														ponteiroPro++;
														

														program[ponteiroPro] = (byte) 0x89;
														ponteiroPro++;

														program[ponteiroPro] = (byte) 0xeb;
														ponteiroPro++;

														program[ponteiroPro] = (byte) 0x45;
														ponteiroPro++;


														program[ponteiroPro] = (byte) 0x45;
														ponteiroPro++;


														program[ponteiroPro] = (byte) 0x8b;
														ponteiroPro++;

														program[ponteiroPro] = (byte) 0x46;
														ponteiroPro++;

														program[ponteiroPro] = (byte) 0x0;
														ponteiroPro++;
														
														
														program[ponteiroPro] = (byte) 0x89;
														ponteiroPro++;

														program[ponteiroPro] = (byte) 0xc5;
														ponteiroPro++;

														program[ponteiroPro] = (byte) 0x8b;
														ponteiroPro++;
														
														

														program[ponteiroPro] = (byte) 0x46;
														ponteiroPro++;

														program[ponteiroPro] = (byte) 0x0;
														ponteiroPro++;
														
														
														program[ponteiroPro] = (byte) 0x89;
														ponteiroPro++;

														program[ponteiroPro] = (byte) 0x7;
														ponteiroPro++;

														
														

														nome.add("ate" + temp1[1].toString().trim() + "2016");
														tipo.add(vtxt);
														endereco.add(ponteiroPro + 10000);
													}
													else
													{

														ss = ss + "erro variavel texto numero parametros linha:" + Integer.toString(ll) + "\n";
													}


												}
												else
												{

													ss = ss + "erro variavel texto numero parametros linha:" + Integer.toString(ll) + "\n";
												}
												break;
											case 22:
												yw1 = 0;
												if (temp1.length == 2)
												{


													int yw2=-1;
													int yw3=0;

													for (int uuu=0;uuu < nome.size();uuu++)
													{

														if (nome.get(uuu).toString().compareToIgnoreCase(temp1[1].toString().trim()) == 0)
														{
															yw2 = uuu;
															uuu = nome.size() + 200;
														}
													}

													if (yw2 != -1)

													{


														int o=0xff & (endereco.get(yw2));
														int oo=0xff00 & (endereco.get(yw2));
														oo = oo >> 8;

														

														program[ponteiroPro] = (byte) 0xb8;
														ponteiroPro++;


														
														program[ponteiroPro] = (byte) o;
														ponteiroPro++;


														program[ponteiroPro] = (byte) oo;
														ponteiroPro++;


														



														yw2 = -1;
														for (int uuu=0;uuu < nome.size();uuu++)
														{

															if (nome.get(uuu).toString().compareToIgnoreCase("ate" + temp1[1].toString().trim() + "2016") == 0)
															{
																yw2 = uuu;
																uuu = nome.size() + 200;
															}
														}

														if (yw2 != -1)
														{


															program[ponteiroPro] = (byte) 0xbf;
															ponteiroPro++;
															o = 0xff & (endereco.get(yw2));
															oo = 0xff00 & (endereco.get(yw2));
															oo = oo >> 8;
															program[ponteiroPro] = (byte) o;
															ponteiroPro++;

															program[ponteiroPro] = (byte) oo;
															ponteiroPro++;

															program[ponteiroPro] = (byte) 0xbe;
															ponteiroPro++;
															o = 0xff & (256 + (3 * 7));
															oo = 0xff00 & (256 + (3 * 7));
															oo = oo >> 8;
															program[ponteiroPro] = (byte) o;
															ponteiroPro++;

															program[ponteiroPro] = (byte) oo;
															ponteiroPro++;

															
															
															
															

															program[ponteiroPro] = (byte) 0xff;
															ponteiroPro++;


															program[ponteiroPro] = (byte) 0xd6;
															ponteiroPro++;

														}
														else
														{
															ss = ss + "erro ler nome variavel indefinido errado linha:" + Integer.toString(ll) + "\n";
														}
													}
													else
													{
														ss = ss + "erro ler nome variavel indefinido errado linha:" + Integer.toString(ll) + "\n";
													}

												}
												else
												{
													ss = ss + "erro ler numero de parametros errado linha:" + Integer.toString(ll) + "\n";
												}
												break;
											case 23:
												if (temp1.length == 4)
												{

													int add=0;
													int add2=0;
													int add3=0;
													int yw2=-1;
													int yw22=-1;
													int yw222=-1;

													for (int uuu=0;uuu < nome.size();uuu++)
													{

														if (nome.get(uuu).toString().compareToIgnoreCase(temp1[1].toString().trim()) == 0)
														{
															yw2 = uuu;
															add = endereco.get(uuu);
															uuu = nome.size() + 200;
														}
													}
													for (int uuu=0;uuu < nome.size();uuu++)
													{

														if (nome.get(uuu).toString().compareToIgnoreCase(temp1[2].toString().trim()) == 0)
														{
															yw22 = uuu;
															add2 = endereco.get(uuu);
															uuu = nome.size() + 200;
														}
													}

													for (int uuu=0;uuu < nome.size();uuu++)
													{

														if (nome.get(uuu).toString().compareToIgnoreCase(temp1[3].toString().trim()) == 0)
														{
															yw222 = uuu;
															add3 = endereco.get(uuu);
															uuu = nome.size() + 200;
														}
													}

													if (yw22 != -1 && yw2 != -1 && yw222 != -1)
													{

														program[ponteiroPro] = (byte) 0xbd;
														ponteiroPro++;


														int o=0xff & (add2);
														int oo=0xff00 & (add2);
														oo = oo >> 8;
														program[ponteiroPro] = (byte) o;
														ponteiroPro++;
														program[ponteiroPro] = (byte) oo;
														ponteiroPro++;


														program[ponteiroPro] = (byte) 0xba;
														ponteiroPro++;


														o = 0xff & (add3);
														oo = 0xff00 & (add3);
														oo = oo >> 8;
														program[ponteiroPro] = (byte) o;
														ponteiroPro++;
														program[ponteiroPro] = (byte) oo;
														ponteiroPro++;



														program[ponteiroPro] = (byte) 0xb9;
														ponteiroPro++;


														o = 0xff & (add);
														oo = 0xff00 & (add);
														oo = oo >> 8;
														program[ponteiroPro] = (byte) o;
														ponteiroPro++;
														program[ponteiroPro] = (byte) oo;
														ponteiroPro++;


														program[ponteiroPro] = (byte) 0xbe;
														ponteiroPro++;

														o = 0xff & (256 + (3 * 8));
														oo = 0xff00 & (256 + (3 * 8));
														oo = oo >> 8;
														program[ponteiroPro] = (byte) o;
														ponteiroPro++;
														program[ponteiroPro] = (byte) oo;
														ponteiroPro++;

														program[ponteiroPro] = (byte) 0xff;
														ponteiroPro++;
														program[ponteiroPro] = (byte) 0xd6;
														ponteiroPro++;


													}



													else
													{

														ss = ss + "erro variavel texto numero parametros linha:" + Integer.toString(ll) + "\n";
													}

												}
												else
												{
													ss = ss + "erro escrever numero de parametros errado linha:" + Integer.toString(ll) + "\n";
												}
												break;
												
											case 24:
												if (temp1.length == 4)
												{

													int add=0;
													int add2=0;
													int add3=0;
													int yw2=-1;
													int yw22=-1;
													int yw222=-1;

													for (int uuu=0;uuu < nome.size();uuu++)
													{

														if (nome.get(uuu).toString().compareToIgnoreCase(temp1[1].toString().trim()) == 0)
														{
															yw2 = uuu;
															add = endereco.get(uuu);
															uuu = nome.size() + 200;
														}
													}
													for (int uuu=0;uuu < nome.size();uuu++)
													{

														if (nome.get(uuu).toString().compareToIgnoreCase(temp1[2].toString().trim()) == 0)
														{
															yw22 = uuu;
															add2 = endereco.get(uuu);
															uuu = nome.size() + 200;
														}
													}

													for (int uuu=0;uuu < nome.size();uuu++)
													{

														if (nome.get(uuu).toString().compareToIgnoreCase(temp1[3].toString().trim()) == 0)
														{
															yw222 = uuu;
															add3 = endereco.get(uuu);
															uuu = nome.size() + 200;
														}
													}

													if (yw22 != -1 && yw2 != -1 && yw222 != -1)
													{

														program[ponteiroPro] = (byte) 0xbd;
														ponteiroPro++;


														int o=0xff & (add2);
														int oo=0xff00 & (add2);
														oo = oo >> 8;
														program[ponteiroPro] = (byte) o;
														ponteiroPro++;
														program[ponteiroPro] = (byte) oo;
														ponteiroPro++;


														program[ponteiroPro] = (byte) 0xba;
														ponteiroPro++;


														o = 0xff & (add3);
														oo = 0xff00 & (add3);
														oo = oo >> 8;
														program[ponteiroPro] = (byte) o;
														ponteiroPro++;
														program[ponteiroPro] = (byte) oo;
														ponteiroPro++;



														program[ponteiroPro] = (byte) 0xb9;
														ponteiroPro++;


														o = 0xff & (add);
														oo = 0xff00 & (add);
														oo = oo >> 8;
														program[ponteiroPro] = (byte) o;
														ponteiroPro++;
														program[ponteiroPro] = (byte) oo;
														ponteiroPro++;


														program[ponteiroPro] = (byte) 0xbe;
														ponteiroPro++;

														o = 0xff & (256 + (3 * 9));
														oo = 0xff00 & (256 + (3 * 9));
														oo = oo >> 8;
														program[ponteiroPro] = (byte) o;
														ponteiroPro++;
														program[ponteiroPro] = (byte) oo;
														ponteiroPro++;

														program[ponteiroPro] = (byte) 0xff;
														ponteiroPro++;
														program[ponteiroPro] = (byte) 0xd6;
														ponteiroPro++;


													}



													else
													{

														ss = ss + "erro variavel texto numero parametros linha:" + Integer.toString(ll) + "\n";
													}

												}
												else
												{
													ss = ss + "erro escrever numero de parametros errado linha:" + Integer.toString(ll) + "\n";
												}
												break;
												case 25:
												if (temp1.length == 4)
												{

													int add=0;
													int add2=0;
													int add3=0;
													int yw2=-1;
													int yw22=-1;
													int yw222=-1;

													for (int uuu=0;uuu < nome.size();uuu++)
													{

														if (nome.get(uuu).toString().compareToIgnoreCase(temp1[1].toString().trim()) == 0)
														{
															yw2 = uuu;
															add = endereco.get(uuu);
															uuu = nome.size() + 200;
														}
													}
													for (int uuu=0;uuu < nome.size();uuu++)
													{

														if (nome.get(uuu).toString().compareToIgnoreCase(temp1[2].toString().trim()) == 0)
														{
															yw22 = uuu;
															add2 = endereco.get(uuu);
															uuu = nome.size() + 200;
														}
													}

													for (int uuu=0;uuu < nome.size();uuu++)
													{

														if (nome.get(uuu).toString().compareToIgnoreCase(temp1[3].toString().trim()) == 0)
														{
															yw222 = uuu;
															add3 = endereco.get(uuu);
															uuu = nome.size() + 200;
														}
													}

													if (yw22 != -1 && yw2 != -1 && yw222 != -1)
													{

														program[ponteiroPro] = (byte) 0xbd;
														ponteiroPro++;


														int o=0xff & (add2);
														int oo=0xff00 & (add2);
														oo = oo >> 8;
														program[ponteiroPro] = (byte) o;
														ponteiroPro++;
														program[ponteiroPro] = (byte) oo;
														ponteiroPro++;


														program[ponteiroPro] = (byte) 0xba;
														ponteiroPro++;


														o = 0xff & (add3);
														oo = 0xff00 & (add3);
														oo = oo >> 8;
														program[ponteiroPro] = (byte) o;
														ponteiroPro++;
														program[ponteiroPro] = (byte) oo;
														ponteiroPro++;



														program[ponteiroPro] = (byte) 0xb9;
														ponteiroPro++;


														o = 0xff & (add);
														oo = 0xff00 & (add);
														oo = oo >> 8;
														program[ponteiroPro] = (byte) o;
														ponteiroPro++;
														program[ponteiroPro] = (byte) oo;
														ponteiroPro++;


														program[ponteiroPro] = (byte) 0xbe;
														ponteiroPro++;

														o = 0xff & (256 + (3 * 10));
														oo = 0xff00 & (256 + (3 * 10));
														oo = oo >> 8;
														program[ponteiroPro] = (byte) o;
														ponteiroPro++;
														program[ponteiroPro] = (byte) oo;
														ponteiroPro++;

														program[ponteiroPro] = (byte) 0xff;
														ponteiroPro++;
														program[ponteiroPro] = (byte) 0xd6;
														ponteiroPro++;


													}



													else
													{

														ss = ss + "erro variavel texto numero parametros linha:" + Integer.toString(ll) + "\n";
													}

												}
												else
												{
													ss = ss + "erro escrever numero de parametros errado linha:" + Integer.toString(ll) + "\n";
												}
												break;
											case 26:
												if (temp1.length == 3)
												{

													int add=0;
													int add2=0;
													int add3=0;
													int yw2=-1;
													int yw22=-1;
													int yw222=-1;

													for (int uuu=0;uuu < nome.size();uuu++)
													{

														if (nome.get(uuu).toString().compareToIgnoreCase(temp1[1].toString().trim()) == 0)
														{
															yw2 = uuu;
															add = endereco.get(uuu);
															uuu = nome.size() + 200;
														}
													}
													for (int uuu=0;uuu < nome.size();uuu++)
													{

														if (nome.get(uuu).toString().compareToIgnoreCase(temp1[2].toString().trim()) == 0)
														{
															yw22 = uuu;
															add2 = endereco.get(uuu);
															uuu = nome.size() + 200;
														}
													}

													

													if (yw22 != -1 && yw2 != -1 )
													{

														program[ponteiroPro] = (byte) 0xbd;
														ponteiroPro++;


														int o=0xff & (add);
														int oo=0xff00 & (add);
														oo = oo >> 8;
														program[ponteiroPro] = (byte) o;
														ponteiroPro++;
														program[ponteiroPro] = (byte) oo;
														ponteiroPro++;


														program[ponteiroPro] = (byte) 0xbb;
														ponteiroPro++;


														o = 0xff & (add2);
														oo = 0xff00 & (add2);
														oo = oo >> 8;
														program[ponteiroPro] = (byte) o;
														ponteiroPro++;
														program[ponteiroPro] = (byte) oo;
														ponteiroPro++;




														program[ponteiroPro] = (byte) 0xbe;
														ponteiroPro++;

														o = 0xff & (256 + (3 * 11));
														oo = 0xff00 & (256 + (3 * 11));
														oo = oo >> 8;
														program[ponteiroPro] = (byte) o;
														ponteiroPro++;
														program[ponteiroPro] = (byte) oo;
														ponteiroPro++;

														program[ponteiroPro] = (byte) 0xff;
														ponteiroPro++;
														program[ponteiroPro] = (byte) 0xd6;
														ponteiroPro++;


													}



													else
													{

														ss = ss + "erro variavel texto numero parametros linha:" + Integer.toString(ll) + "\n";
													}

												}
												else
												{
													ss = ss + "erro escrever numero de parametros errado linha:" + Integer.toString(ll) + "\n";
												}
												break;
												
												
											case 27:
												if (temp1.length == 1)
												{

													int add=0;
													int add2=0;
													int add3=0;
													int yw2=-1;
													int yw22=-1;
													int yw222=-1;








													program[ponteiroPro] = (byte) 0xbe;
													ponteiroPro++;

													int o = 0xff & (256 + (3 * 12));
													int oo = 0xff00 & (256 + (3 * 12));
													oo = oo >> 8;
													program[ponteiroPro] = (byte) o;
													ponteiroPro++;
													program[ponteiroPro] = (byte) oo;
													ponteiroPro++;

													program[ponteiroPro] = (byte) 0xff;
													ponteiroPro++;
													program[ponteiroPro] = (byte) 0xd6;
													ponteiroPro++;







												}
												else
												{
													ss = ss + "erro escrever numero de parametros errado linha:" + Integer.toString(ll) + "\n";
												}
												break;
												
												
											case 28:
												if (temp1.length == 1)
												{

													int add=0;
													int add2=0;
													int add3=0;
													int yw2=-1;
													int yw22=-1;
													int yw222=-1;








													program[ponteiroPro] = (byte) 0xbe;
													ponteiroPro++;

													int o = 0xff & (256 + (3 * 13));
													int oo = 0xff00 & (256 + (3 * 13));
													oo = oo >> 8;
													program[ponteiroPro] = (byte) o;
													ponteiroPro++;
													program[ponteiroPro] = (byte) oo;
													ponteiroPro++;

													program[ponteiroPro] = (byte) 0xff;
													ponteiroPro++;
													program[ponteiroPro] = (byte) 0xd6;
													ponteiroPro++;







												}
												else
												{
													ss = ss + "erro escrever numero de parametros errado linha:" + Integer.toString(ll) + "\n";
												}
												break;
												
												
											case 29:
												if (temp1.length == 1)
												{

													int add=0;
													int add2=0;
													int add3=0;
													int yw2=-1;
													int yw22=-1;
													int yw222=-1;








													program[ponteiroPro] = (byte) 0xbe;
													ponteiroPro++;

													int o = 0xff & (256 + (3 * 14));
													int oo = 0xff00 & (256 + (3 * 14));
													oo = oo >> 8;
													program[ponteiroPro] = (byte) o;
													ponteiroPro++;
													program[ponteiroPro] = (byte) oo;
													ponteiroPro++;

													program[ponteiroPro] = (byte) 0xff;
													ponteiroPro++;
													program[ponteiroPro] = (byte) 0xd6;
													ponteiroPro++;







												}
												else
												{
													ss = ss + "erro escrever numero de parametros errado linha:" + Integer.toString(ll) + "\n";
												}
												break;

											case 30:
												if (temp1.length == 3)
												{

													int add=0;
													int add2=0;
													int add3=0;
													int yw2=-1;
													int yw22=-1;
													int yw222=-1;

													for (int uuu=0;uuu < nome.size();uuu++)
													{

														if (nome.get(uuu).toString().compareToIgnoreCase(temp1[1].toString().trim()) == 0)
														{
															yw2 = uuu;
															add = endereco.get(uuu);
															uuu = nome.size() + 200;
														}
													}
													for (int uuu=0;uuu < nome.size();uuu++)
													{

														if (nome.get(uuu).toString().compareToIgnoreCase(temp1[2].toString().trim()) == 0)
														{
															yw22 = uuu;
															add2 = endereco.get(uuu);
															uuu = nome.size() + 200;
														}
													}



													if (yw22 != -1 && yw2 != -1 )
													{

														program[ponteiroPro] = (byte) 0xbd;
														ponteiroPro++;


														int o=0xff & (add2);
														int oo=0xff00 & (add2);
														oo = oo >> 8;
														program[ponteiroPro] = (byte) o;
														ponteiroPro++;
														program[ponteiroPro] = (byte) oo;
														ponteiroPro++;


														program[ponteiroPro] = (byte) 0xbb;
														ponteiroPro++;


														o = 0xff & (add);
														oo = 0xff00 & (add);
														oo = oo >> 8;
														program[ponteiroPro] = (byte) o;
														ponteiroPro++;
														program[ponteiroPro] = (byte) oo;
														ponteiroPro++;




														program[ponteiroPro] = (byte) 0xbe;
														ponteiroPro++;

														o = 0xff & (256 + (3 * 15));
														oo = 0xff00 & (256 + (3 * 15));
														oo = oo >> 8;
														program[ponteiroPro] = (byte) o;
														ponteiroPro++;
														program[ponteiroPro] = (byte) oo;
														ponteiroPro++;

														program[ponteiroPro] = (byte) 0xff;
														ponteiroPro++;
														program[ponteiroPro] = (byte) 0xd6;
														ponteiroPro++;


													}



													else
													{

														ss = ss + "erro variavel texto numero parametros linha:" + Integer.toString(ll) + "\n";
													}

												}
												else
												{
													ss = ss + "erro escrever numero de parametros errado linha:" + Integer.toString(ll) + "\n";
												}
												break;

												
											case 31:
												if (temp1.length == 3)
												{

													int add=0;
													int add2=0;
													int add3=0;
													int yw2=-1;
													int yw22=-1;
													int yw222=-1;

													for (int uuu=0;uuu < nome.size();uuu++)
													{

														if (nome.get(uuu).toString().compareToIgnoreCase(temp1[1].toString().trim()) == 0)
														{
															yw2 = uuu;
															add = endereco.get(uuu);
															uuu = nome.size() + 200;
														}
													}
													for (int uuu=0;uuu < nome.size();uuu++)
													{

														if (nome.get(uuu).toString().compareToIgnoreCase(temp1[2].toString().trim()) == 0)
														{
															yw22 = uuu;
															add2 = endereco.get(uuu);
															uuu = nome.size() + 200;
														}
													}



													if (yw22 != -1 && yw2 != -1 )
													{

														program[ponteiroPro] = (byte) 0xbd;
														ponteiroPro++;


														int o=0xff & (add2);
														int oo=0xff00 & (add2);
														oo = oo >> 8;
														program[ponteiroPro] = (byte) o;
														ponteiroPro++;
														program[ponteiroPro] = (byte) oo;
														ponteiroPro++;


														program[ponteiroPro] = (byte) 0xbb;
														ponteiroPro++;


														o = 0xff & (add);
														oo = 0xff00 & (add);
														oo = oo >> 8;
														program[ponteiroPro] = (byte) o;
														ponteiroPro++;
														program[ponteiroPro] = (byte) oo;
														ponteiroPro++;




														program[ponteiroPro] = (byte) 0xbe;
														ponteiroPro++;

														o = 0xff & (256 + (3 * 16));
														oo = 0xff00 & (256 + (3 * 16));
														oo = oo >> 8;
														program[ponteiroPro] = (byte) o;
														ponteiroPro++;
														program[ponteiroPro] = (byte) oo;
														ponteiroPro++;

														program[ponteiroPro] = (byte) 0xff;
														ponteiroPro++;
														program[ponteiroPro] = (byte) 0xd6;
														ponteiroPro++;


													}



													else
													{

														ss = ss + "erro variavel texto numero parametros linha:" + Integer.toString(ll) + "\n";
													}

												}
												else
												{
													ss = ss + "erro escrever numero de parametros errado linha:" + Integer.toString(ll) + "\n";
												}
												break;
												
												
											default:
												ss = ss + "erro palavra chave invalida linha:" + Integer.toString(ll) + "\n";

										}

									}

								}

								line = reader.readLine();
							}
							program[ponteiroPro] = (byte) 0xc3;
							ponteiroPro++;
							for (int uuu1=0;uuu1 < salto.size();uuu1++)
							{

								ss = ss + "salto ou chamada não defenida:" + salto.get(uuu1).toString() + ":linha:" + Integer.toString(posicao.get(uuu1)) + "\n";

							}
							ss = ss + "fim\n";
							ss=ss+"programa:"+ Integer.toString(ponteiroPro)+"  de 10000 bytes\n";
							
							ss=ss+"variaveis:"+ Integer.toString(ponteiroVar)+"  de 10000 bytes\n";
							
							ss=ss+"dados:"+ Integer.toString(ponteiroTxt)+"  de 20000 bytes\n";
							
							

							while ((size = ins.read(buffer, 0, 1024)) >= 0)
							{
								outputStream.write(buffer, 0, size);
							}
							ins.close();
							int f=10000 - 256 - outputStream.size();


							setTitle("a compilar");

							ins.close();
							byte[] buffer2 = new byte[f];
							outputStream.write(buffer2, 0, f);
							outputStream.write(program, 0, 10000);
							outputStream.write(variaveis, 0, 10000);
							outputStream.write(textos, 0, 30000);
							buffer = outputStream.toByteArray();

							String ssx="/sdcard/uindex/" + gg[0].trim() + ".com";
							FileOutputStream fos = new FileOutputStream(ssx);
							fos.write(buffer);


							fos.close();
							setTitle("compilação terminada sucesso");

						}
						else
						{
							setTitle("ficheiro não encontrado");
							ss = "ficheiro não encontrado";
						}




						TV.setText(ss);

					}
					catch (Exception e)

					{

						ss = ss + "\nerro fatal na linha:" + Integer.toString(ll) + "\n";
						
						ss=ss+"programa:"+ Integer.toString(ponteiroPro)+"  de 10000 bytes\n";

						ss=ss+"variaveis:"+ Integer.toString(ponteiroVar)+"  de 10000 bytes\n";

						ss=ss+"dados:"+ Integer.toString(ponteiroTxt)+"  de 20000 bytes\n";
						TV.setText(ss);

						setTitle(e.toString());

					}


				} 

			}); 


	}
}











