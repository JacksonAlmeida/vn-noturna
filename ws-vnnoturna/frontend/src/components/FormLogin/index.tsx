import './styles.css';
import logo from '../../assets/img/logo.png';

function FormLogin() {
    return (
        <>
            <div className="container">

                <div className="container-form">
                    <div className="container-form-logo">
                        <h2>Seja Bem-vindo!</h2>
                        <img src={logo} alt="conatiner-form-logo" />

                    </div>

                    <div className="container-form-login">
                            <h2>Login</h2>
                        <form action="" method="post">
                            <label>
                                Email: <input type="email" name="email" id="email" placeholder="Digite seu email aqui!" />
                            </label>
                            <label>
                                Passord: <input type="password" name="password" id="password" placeholder="Dgite seua senha aqui!" />
                            </label>
                            <button type="submit">Login</button>
                        </form>
                    </div>
                </div>

            </div>
        </>
    )
}

export default FormLogin;