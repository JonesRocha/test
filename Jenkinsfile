stage 'Checkout'
 node('master') {
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
  sh 'echo "Os lábios da sabedoria estão fechados, exceto aos ouvidos do entendimento." > Trismegisto.txt'
  fileExists 'Trismegisto.txt'
 }
