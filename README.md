Projeto feito com JDK17 e usando Java binding for Open GL.

Caso use NetBeans ou Eclipse, é necessário fazer download da biblioteca:
https://jogamp.org/wiki/index.php/Downloading_and_installing_JOGL

Os arquivos necessários mudam conforme o sistema operacional.

Para 64-bit Windows:

gluegen-rt.jar
jogl-all.jar
gluegen-java-src.zip
jogl-java-src-zip
gluegen-rt-natives-windows-amd64.jar
jogl-all-natives-windows-amd64.jar


Para 64-bit Linux:

gluegen-rt.jar
jogl-all.jar
gluegen-java-src.zip
jogl-java-src-zip
gluegen-rt-natives-linux-amd64.jar
jogl-all-natives-linux-amd64.jar


Para 32/64-bit Mac:

gluegen-rt.jar
jogl-all.jar
gluegen-java-src.zip
jogl-java-src-zip
gluegen-rt-natives-macosx-universal.jar
jogl-all-natives-macosx-universal.jar

Depois, abra o Netbeans/Eclipse 🡪 Menu Ferramentas 🡪 Bibliotecas
Selecione JOGL 🡪 Botão “Adicionar JAR/Pasta” e adicione os arquivos, nomeie como JOGL

Após isso, a biblioteca já está salva na IDE.
Para rodar, selecione o projeto, clique com botáo direito e vá em Propriedades 🡪 Bibliotecas 
Clique no botão de "Adicionar bibliotecas", escolha JOGL e clique em OK.

O projeto está pronto pra rodar!
