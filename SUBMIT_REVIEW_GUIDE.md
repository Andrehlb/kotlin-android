# Guia para Submit Review - Kotlin Android

## O que escrever no Submit Review

Um submit review bem escrito é fundamental para facilitar a revisão de código e manter a qualidade do projeto. Este guia fornece diretrizes sobre o que incluir em um submit review para projetos Kotlin Android.

## Estrutura do Submit Review

### 1. Título Claro e Descritivo

```
[TIPO] Descrição breve da mudança

Exemplos:
- [FEAT] Adiciona tela de login com autenticação
- [FIX] Corrige crash ao salvar dados offline
- [REFACTOR] Melhora performance da lista de produtos
- [DOCS] Atualiza documentação da API
```

### 2. Descrição Detalhada

#### 2.1 Resumo das Mudanças
```markdown
## Resumo
Breve descrição do que foi implementado, corrigido ou melhorado.

## Motivação
Explique por que esta mudança foi necessária:
- Problema que resolve
- Feature solicitada
- Melhoria de performance
- Correção de bug
```

#### 2.2 Mudanças Técnicas
```markdown
## Mudanças Implementadas

### Arquitetura
- [ ] Novos componentes criados
- [ ] Modificações em classes existentes
- [ ] Mudanças na estrutura de dados
- [ ] Alterações na navegação

### Código Kotlin/Android
- [ ] Novas Activities/Fragments
- [ ] ViewModels criados/modificados
- [ ] Repositórios e fontes de dados
- [ ] Adapters e ViewHolders
- [ ] Recursos (layouts, strings, drawables)
```

### 3. Testes

```markdown
## Testes Realizados

### Testes Unitários
- [ ] Novos testes unitários adicionados
- [ ] Testes existentes atualizados
- [ ] Cobertura de código mantida/melhorada

### Testes de Interface
- [ ] Testes de UI adicionados
- [ ] Testes de navegação
- [ ] Testes de integração

### Testes Manuais
- [ ] Testado em diferentes dispositivos
- [ ] Testado em diferentes versões do Android
- [ ] Testado cenários de edge case
- [ ] Testado offline/online
```

### 4. Checklist de Qualidade

```markdown
## Checklist de Qualidade

### Código
- [ ] Código segue padrões do projeto
- [ ] Nomes de variáveis/métodos são descritivos
- [ ] Comentários adicionados onde necessário
- [ ] Código duplicado removido/refatorado
- [ ] Tratamento de erros implementado

### Performance
- [ ] Não há vazamentos de memória
- [ ] Operações pesadas em background threads
- [ ] Imagens otimizadas
- [ ] Queries de banco eficientes

### UX/UI
- [ ] Interface responsiva
- [ ] Suporte a modo escuro (se aplicável)
- [ ] Acessibilidade considerada
- [ ] Estados de loading implementados
- [ ] Tratamento de estados de erro

### Compatibilidade
- [ ] Testado no minSdkVersion
- [ ] Testado no targetSdkVersion
- [ ] Não quebra funcionalidades existentes
```

### 5. Screenshots/Videos (se aplicável)

```markdown
## Demonstração Visual

### Antes
[Screenshot ou descrição do estado anterior]

### Depois
[Screenshot ou descrição do novo estado]

### Video Demo (se necessário)
[Link para video demonstrando a funcionalidade]
```

### 6. Dependências e Configurações

```markdown
## Dependências

### Novas Dependências
- [ ] Biblioteca X versão Y.Z
- [ ] Plugin A versão B.C

### Mudanças de Configuração
- [ ] Gradle build scripts
- [ ] Manifest permissions
- [ ] ProGuard rules
- [ ] Configurações de build variants
```

### 7. Documentação

```markdown
## Documentação

- [ ] README atualizado
- [ ] Comentários de código adicionados
- [ ] Documentação da API atualizada
- [ ] Changelog atualizado
```

### 8. Notas para Revisores

```markdown
## Notas para Revisores

### Pontos de Atenção
- Foque especialmente na implementação de [área específica]
- Verifique se a performance não foi impactada
- Confirme se os testes cobrem os casos edge

### Áreas que Precisam de Atenção Especial
- [Arquivo/método específico que merece atenção]
- [Lógica complexa implementada]
- [Possíveis impacts em outras partes do código]
```

## Exemplo Completo

```markdown
# [FEAT] Implementa cache offline para lista de produtos

## Resumo
Implementa sistema de cache local para a lista de produtos, permitindo que o app funcione offline e melhore a experiência do usuário com carregamento mais rápido.

## Motivação
- Usuários relataram lentidão no carregamento da lista
- App não funcionava sem conexão com internet
- Solicitação do product owner para melhorar UX

## Mudanças Implementadas

### Arquitetura
- [x] Adicionado Room database para cache local
- [x] Implementado Repository pattern
- [x] Criado NetworkBoundResource para sincronização

### Código Kotlin/Android
- [x] ProductDao para operações de banco
- [x] ProductEntity para modelo local
- [x] ProductRepository com cache strategy
- [x] Atualizado ProductViewModel
- [x] Adicionado indicador de estado offline

## Testes Realizados

### Testes Unitários
- [x] ProductRepositoryTest - 95% coverage
- [x] ProductDaoTest - 100% coverage
- [x] ProductViewModelTest atualizado

### Testes Manuais
- [x] Testado com/sem internet
- [x] Testado em Android 7-13
- [x] Testado refresh pull-to-refresh
- [x] Testado primeiro carregamento

## Checklist de Qualidade
- [x] Código segue padrões Kotlin
- [x] Repository pattern implementado
- [x] Tratamento de erros de rede
- [x] Loading states implementados
- [x] Sem vazamentos de memória

## Screenshots
Antes: Lista vazia sem internet
Depois: Lista carregada do cache offline

## Dependências
- room-runtime: 2.4.3
- room-ktx: 2.4.3

## Notas para Revisores
Foque na implementação do NetworkBoundResource em ProductRepository.kt
Verifique se a migração do banco está correta.
```

## Dicas Adicionais

1. **Seja específico**: Evite descrições vagas como "pequenos ajustes"
2. **Contextualize**: Explique o problema que está resolvendo
3. **Facilite a revisão**: Destaque pontos importantes
4. **Seja honesto**: Mencione limitações ou trade-offs
5. **Pense no futuro**: Como isso afeta manutenibilidade

## Links Úteis

- [Conventional Commits](https://www.conventionalcommits.org/)
- [Android Code Review Guidelines](https://developer.android.com/guide)
- [Kotlin Coding Conventions](https://kotlinlang.org/docs/coding-conventions.html)