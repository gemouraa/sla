import ListaDeJogadores from '../../components/ListaDeUsuarios'
import { useNavigate } from 'react-router-dom'
import './styles.css'

function PaginaListaJogadores() {
    const navigate = useNavigate()
    
    return (
        <div className='pagina-lista-usuarios'>
            <div className='container'>
                <h2>Lista de Jogadores</h2>
                <ListaDeJogadores />
                <button onClick={() => navigate('/')} className='link-voltar'>
                    Cadastrar Jogadores
                </button>
            </div>
        </div>
    )
}

export default PaginaListaJogadores
