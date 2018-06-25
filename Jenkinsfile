stage 'Checkout'
 node('master') {
  echo 'Iniciando...'
  deleteDir()
  checkout scm
  fileExists 'testeDeArquivo.txt'
 }

stage 'Mensagem de Teste'
 node('master') {
  fileExists 'contributors.txt'
  echo 'Eis aqui uma mensagem de teste no novo passo que criei no jenkins'
 }

stage 'Script'
 node('master') {
  script {
   def browsers = ['chrome', 'firefox']
   for (int i = 0; i < browsers.size(); ++i) {
     echo "Testing the ${browsers[i]} browser"
   }
  }
 }

stage 'Cria e Valida Arquivo'
 node('master') {
  if (fileExists('Trismegisto.txt')) {
     echo 'Já existe!'
  } else {
     sh 'echo "Os lábios da sabedoria estão fechados, exceto aos ouvidos do entendimento." > Trismegisto.txt'
     sh 'git checkout master'
     sh 'git add Trismegisto.txt'
     sh 'git config --global user.email "jones_rocha@yahoo.com.br"'
     sh 'git config --global user.name "JonesRocha"'
     sh 'git commit -m "outro passo"'
     sh 'git push https://JonesRocha:Sextante73!@github.com/JonesRocha/test.git HEAD:master'
  }
 }

stage 'Adição'
 node('master') {
  if (fileExists('src')) {
     echo 'Já existe!'
  } else {
     sh 'git checkout master'
     sh 'git add src'
     sh 'git config --global user.email "jones_rocha@yahoo.com.br"'
     sh 'git config --global user.name "JonesRocha"'
     sh 'git commit -m "adição do src"'
     sh 'git push https://JonesRocha:Sextante73!@github.com/JonesRocha/test.git HEAD:master'
  }
 }

stage 'Mensagem'
 node('master') {
  echo 'Aqui finaliza por enquanto.'
  println("Códigos em groove...")
  for (int i = 1; i <= 9; ++i) {
    println("Contando... " + i)
  }
 }

stage 'Novo'
 node('master') {
  println("Nova \"stage\"")
 }

stage 'e-mail'
 node('master') {
  emailext body: 'Aqui é um teste.', recipientProviders: [developers()], subject: 'Teste', to: 'jones_rocha@yahoo.com.br'
 }

stage 'Valid'
 node('master') {
  echo 'Verifica se existe!'
  if (fileExists('src/Main.java')) {
     echo 'Já existe o src/Main.java!'
  }
  if (fileExists('src/Nmrlgia.java')) {
     echo 'Já existe! o src/Nmrlgia.java'
  }
  if (fileExists('contributors.txt')) {
     echo 'o arquivo contributors.txt existe já.'
  }
 }
