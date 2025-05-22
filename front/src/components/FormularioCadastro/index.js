import { useState } from "react";
import './styles.css'
import { useNavigate } from "react-router-dom";
import useMensagem from '../../hooks/useMensagem'
import MensagemFeedback from '../MensagemFeedback'

import logo from '../../assets/images/logo.png'
import axios from 'axios'

function FormularioCadastro() {
    const [nome, setNome] = useState('')
    const [sexo, setSexo] = useState('')
    const [idade, setIdade] = useState('')
    const [altura, setAltura] = useState('')
    const [peso, setPeso] = useState('')
    const [posicao, setPosicao] = useState('')
    const [numeroCamisa, setNumeroCamisa] = useState('')

    const navigate = useNavigate()
    const { exibirMensagem , mensagem, tipoMensagem, visivel, fecharMensagem } = useMensagem()

    const cadastrarJogador = async () => {
        try {
            const response = await axios.post('http://localhost:8080/jogadores', {
                nome, sexo, idade, altura, peso, posicao, numeroCamisa
            })
            exibirMensagem('Jogador cadastrado com sucesso!', 'sucesso')
            setNome('')
            setSexo('')
            setIdade('')
            setAltura('')
            setPeso('')
            setPosicao('')
            setNumeroCamisa('')
        } catch (error) {
            let erroMsg = 'Erro ao conectar ao servidor.'
            if (error.response && error.response.data) {
                erroMsg = error.response.data.mensagem || erroMsg
            }
            exibirMensagem(erroMsg, 'erro')
        }
    }

    return (
        <div className="container">
            <img src={logo} alt="Logo do time" />
            <h2>Cadastro de Jogadores</h2>
            <form onSubmit={(e) => {e.preventDefault(); cadastrarJogador()}}>
                <input type="text" placeholder="Nome" value={nome} onChange={(e) => setNome(e.target.value)} required />
                <input type="text" placeholder="Sexo" value={sexo} onChange={(e) => setSexo(e.target.value)} required />
                <input type="number" placeholder="Idade" value={idade} onChange={(e) => setIdade(e.target.value)} required />
                <input type="number" step="0.01" placeholder="Altura (ex: 1.80)" value={altura} onChange={(e) => setAltura(e.target.value)} required />
                <input type="number" placeholder="Peso (kg)" value={peso} onChange={(e) => setPeso(e.target.value)} required />
                <input type="text" placeholder="Posição" value={posicao} onChange={(e) => setPosicao(e.target.value)} required />
                <input type="number" placeholder="Número da Camisa" value={numeroCamisa} onChange={(e) => setNumeroCamisa(e.target.value)} required />
                <button type="submit">Cadastrar</button>
            </form>

            <button onClick={() => navigate('/jogadores')} className="link-usuarios">
                Ver jogadores cadastrados
            </button>

            <MensagemFeedback
                mensagem={mensagem}
                tipo={tipoMensagem}
                visivel={visivel}
                onclose={fecharMensagem}
            />
        </div>
    )
}

export default FormularioCadastro
