stage 'Checkout'
 node('master') {
  echo 'Iniciando...'
  notify('Iniciando os esquemas...')

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
   def browsers = ['chrome', 'firefox', 'opera']
   for (int i = 0; i < browsers.size(); ++i) {
     echo "Testing the ${browsers[i]} browser"
   }
  }
 }

stage 'Cria e Valida'
 node('master') {
  if (fileExists('Trismegisto.txt')) {
     echo 'O arquivo Trismegisto.txt já existe!'
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
     echo 'O diretório "src" já existe!'
  } else {
     sh 'git checkout master'
     sh 'git add src'
     sh 'git config --global user.email "jones_rocha@yahoo.com.br"'
     sh 'git config --global user.name "JonesRocha"'
     sh 'git commit -m "adição do src"'
     sh 'git push https://JonesRocha:Sextante73!@github.com/JonesRocha/test.git HEAD:master'
  }
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

  notify('Finalizado com sucesso!')
 }

pipeline {
    agent any
    stages {
        stage('Example') {
            steps {
                echo 'Hello World'
            }
        }
    }
    post { 
        always { 
            echo 'I will always say Hello again!'
        }
    }
}

def notify(status) {
    emailext (
      to: "jones.rocha@matera.com",
      subject: "${status}: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]'",
      body: """<p>${status}: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]':</p>
        <p>Check console output at <a href='${env.BUILD_URL}'>${env.JOB_NAME} [${env.BUILD_NUMBER}]</a></p>""",
    )
}
