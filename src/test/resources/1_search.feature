Feature: Search Repository

  Scenario Outline: As a Guest User Search For a Repository and Find Expected Repository
    Given User first visit the gitHub website
    When As a guest user search for a repository "<repoName>"
    Then User can see a count matching result
    And User verify and find the "<expectedRepo>"
    Examples:
      | repoName         |  | expectedRepo              |
      | create-react-app |  | facebook/create-react-app |
